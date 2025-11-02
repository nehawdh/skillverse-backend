package com.skillverse.features.courses;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {
  private final CourseRepository courses;
  private final CourseMapper mapper;

  @GetMapping
  public List<CourseDto> list() {
    return courses.findAll().stream().map(mapper::toDto).toList();
  }

  @PostMapping
  public CourseDto create(@Valid @RequestBody Course in) {
    in.setId(null);
    var saved = courses.save(in);
    return mapper.toDto(saved);
  }

  @GetMapping("/{id}")
  public CourseDto get(@PathVariable Long id) {
    var c = courses.findById(id)
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found"));
    return mapper.toDto(c);
  }

  @PatchMapping("/{id}")
  public CourseDto patch(@PathVariable Long id, @RequestBody Map<String,Object> p) {
    var c = courses.findById(id)
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found"));
    if (p.containsKey("title")) c.setTitle((String)p.get("title"));
    if (p.containsKey("subtitle")) c.setSubtitle((String)p.get("subtitle"));
    if (p.containsKey("level")) c.setLevel(Course.Level.valueOf(((String)p.get("level")).toUpperCase()));
    if (p.containsKey("status")) c.setStatus(Course.Status.valueOf(((String)p.get("status")).toUpperCase()));
    return mapper.toDto(courses.save(c));
  }
}
