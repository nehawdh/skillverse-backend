package com.skillverse.features.courses;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.*;
@Entity @Table(name = "course_modules")
@Data @NoArgsConstructor @AllArgsConstructor
public class ModuleItem {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank private String title;
  private Integer orderIndex = 0;

  @ManyToOne(optional = false) @JoinColumn(name = "course_id")
  private Course course;
}
