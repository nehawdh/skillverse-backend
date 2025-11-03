package com.skillverse.features.auth;

import com.skillverse.features.auth.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class AuthController {

  private final UserRepository users;
  private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

  // Env var: JWT_SECRET (at least 32 chars)
  private final String jwtSecret = System.getenv().getOrDefault("JWT_SECRET",
      "change-this-secret-to-something-long-and-random-1234567890");

  @PostMapping("/signup")
  @ResponseStatus(HttpStatus.CREATED)
  public AuthResponse signup(@RequestBody SignupRequest req) {
    if (req.email() == null || req.password() == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "email and password required");
    }
    if (users.existsByEmail(req.email().toLowerCase())) {
      throw new ResponseStatusException(HttpStatus.CONFLICT, "email already registered");
    }
    var u = new User();
    u.setEmail(req.email().toLowerCase());
    u.setPasswordHash(encoder.encode(req.password()));
    u.setName(req.name());
    u.setRole((req.role() == null || req.role().isBlank()) ? "STUDENT" : req.role().toUpperCase());
    u = users.save(u);

    var token = JwtUtil.generate(u.getId().toString(), u.getRole(), jwtSecret, 7);
    return new AuthResponse(token, u.getId(), u.getEmail(), u.getRole());
  }

  @PostMapping("/login")
  public AuthResponse login(@RequestBody LoginRequest req) {
    var u = users.findByEmail(req.email().toLowerCase())
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "invalid credentials"));
    if (!encoder.matches(req.password(), u.getPasswordHash())) {
      throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "invalid credentials");
    }
    var token = JwtUtil.generate(u.getId().toString(), u.getRole(), jwtSecret, 7);
    return new AuthResponse(token, u.getId(), u.getEmail(), u.getRole());
  }
}
