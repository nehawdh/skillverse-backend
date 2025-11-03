package com.skillverse.features.auth;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Map;

public class JwtUtil {

  public static String generate(String subject, String role, String secret, long daysValid) {
    SecretKey key = Keys.hmacShaKeyFor(secret.getBytes());
    Instant now = Instant.now();
    return Jwts.builder()
        .setSubject(subject)
        .addClaims(Map.of("role", role))
        .setIssuedAt(Date.from(now))
        .setExpiration(Date.from(now.plus(daysValid, ChronoUnit.DAYS)))
        .signWith(key, SignatureAlgorithm.HS256)
        .compact();
  }
}
