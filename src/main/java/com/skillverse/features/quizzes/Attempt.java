package com.skillverse.features.quizzes;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import  jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import java.time.Instant;

@Entity @Table(name="quiz_attempts")
@Data @NoArgsConstructor @AllArgsConstructor
public class Attempt {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Long userId;       // integrate Keycloak later
  @ManyToOne(optional=false) @JoinColumn(name="quiz_id")
  private Quiz quiz;

  private Integer score = 0;
  private Instant startedAt = Instant.now();
  private Instant submittedAt;

  @Column(columnDefinition="TEXT")
  private String detailJson; // answers given, etc.
}
