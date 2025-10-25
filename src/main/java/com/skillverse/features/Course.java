package com.skillverse.features;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import java.time.Instant;

@Entity @Table(name = "courses")
@Data @NoArgsConstructor @AllArgsConstructor
public class Course {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank private String title;
  private String subtitle;
  private String level;        // "BEGINNER" | "INTERMEDIATE" | "ADVANCED"
  private Integer modulesCount = 0;
  private String status = "DRAFT";   // "DRAFT" | "PUBLISHED"
  private Instant createdAt = Instant.now();
}
