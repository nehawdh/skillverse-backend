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
@Entity @Table(name = "lessons")
@Data @NoArgsConstructor @AllArgsConstructor
public class Lesson {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank private String title;

  @Enumerated(EnumType.STRING)
  private Type type = Type.VIDEO; // VIDEO/PDF/TEXT/QUIZ

  private String contentUrl;  // video/pdf URL
  @Column(columnDefinition = "TEXT")
  private String transcript;

  private Integer orderIndex = 0;
  private Integer durationSec;

  @ManyToOne(optional = false) @JoinColumn(name = "module_id")
  private ModuleItem module;

  public enum Type { VIDEO, PDF, TEXT, QUIZ }
}
