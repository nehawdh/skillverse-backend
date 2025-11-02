package com.skillverse.features.quizzes;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.NotBlank;

import com.skillverse.features.courses.Lesson;

@Entity @Table(name="quizzes")
@Data @NoArgsConstructor @AllArgsConstructor
public class Quiz {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank private String title;
  private Integer totalPoints = 0;

  @OneToOne @JoinColumn(name="lesson_id")
  private Lesson lesson; // quiz attached to a Lesson
}
