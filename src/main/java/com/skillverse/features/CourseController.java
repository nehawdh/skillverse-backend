package com.skillverse.features;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/courses")
@CrossOrigin(origins = "*") // later: restrict to your Vercel domain
@RequiredArgsConstructor
public class CourseController {
  private final CourseRepository repo;

  @GetMapping public List<Course> list() { return repo.findAll(); }

  @PostMapping public Course create(@Valid @RequestBody Course c) {
    c.setId(null);
    return repo.save(c);
  }

  @GetMapping("/{id}") public Course get(@PathVariable Long id) {
    return repo.findById(id).orElseThrow(() ->
      new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found"));
  }

  @PatchMapping("/{id}") public Course patch(@PathVariable Long id, @RequestBody Map<String,Object> p) {
    Course c = repo.findById(id).orElseThrow(() ->
      new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found"));
    if (p.containsKey("title")) c.setTitle((String)p.get("title"));
    if (p.containsKey("subtitle")) c.setSubtitle((String)p.get("subtitle"));
    if (p.containsKey("level")) c.setLevel((String)p.get("level"));
    if (p.containsKey("status")) c.setStatus((String)p.get("status"));
    if (p.containsKey("modulesCount")) c.setModulesCount((Integer)p.get("modulesCount"));
    return repo.save(c);
  }
}
