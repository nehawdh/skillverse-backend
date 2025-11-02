
package com.skillverse.features.courses;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {
  public CourseDto toDto(Course c) {
    return new CourseDto(c.getId(), c.getTitle(), c.getSubtitle(),
      c.getLevel().name(), c.getModulesCount(), c.getStatus().name(), c.getCreatedAt());
  }
}
