package com.skillverse.features.courses;



import java.time.Instant;

import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.*;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Table(name = "courses")
@Data @NoArgsConstructor @AllArgsConstructor
public class Course {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank private String title;
  private String subtitle;

  @Enumerated(EnumType.STRING)
  private Level level = Level.BEGINNER;  // BEGINNER/INTERMEDIATE/ADVANCED

  private Integer modulesCount = 0;
  @Enumerated(EnumType.STRING)
  private Status status = Status.DRAFT; // DRAFT/PUBLISHED

  private Instant createdAt = Instant.now();

  public enum Level { BEGINNER, INTERMEDIATE, ADVANCED }
  public enum Status { DRAFT, PUBLISHED }
}
