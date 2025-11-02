package com.skillverse.features.quizzes;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;


@Entity @Table(name="quiz_questions")
@Data @NoArgsConstructor @AllArgsConstructor
public class QuizQuestion {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(optional=false) @JoinColumn(name="quiz_id")
  private Quiz quiz;

  @NotBlank @Column(columnDefinition="TEXT")
  private String stem;

  @NotNull @Column(columnDefinition="TEXT")
  private String optionsJson; // store ["A","B","C","D"] as JSON

  @NotBlank
  private String answerKey; // e.g. "B"

  private Integer points = 1;
}
