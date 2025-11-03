package com.skillverse.features.enrollments;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/enrollments")
@CrossOrigin(origins = "*") // Later restrict to your Vercel domain
@RequiredArgsConstructor
public class EnrollmentController {

    private final EnrollmentRepository repo;

    @GetMapping
    public List<Enrollment> listAll() {
        return repo.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Enrollment create(@RequestBody Enrollment e) {
        if (e.getUserId() == null || e.getCourse() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "userId and courseId are required");
        }
        return repo.save(e);
    }

    @GetMapping("/user/{userId}")
    public List<Enrollment> listByUser(@PathVariable Long userId) {
        return repo.findByUserId(userId);
    }

    @PatchMapping("/{id}")
    public Enrollment update(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        Enrollment e = repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Enrollment not found"));

        if (updates.containsKey("progressPct"))
            e.setProgressPct((Integer) updates.get("progressPct"));
        if (updates.containsKey("completedAt"))
            e.setCompletedAt(java.time.Instant.parse((String) updates.get("completedAt")));

        return repo.save(e);
    }
}
