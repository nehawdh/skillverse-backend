package com.skillverse.features.enrollments;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.time.Instant;
@Entity @Table(name="enrollments",
  uniqueConstraints = @UniqueConstraint(columnNames={"user_id","course_id"}))
@Data @NoArgsConstructor @AllArgsConstructor
public class Enrollment {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Long userId;   // replace with real User entity when you add Keycloak sync
  //@Column(name = "course_id", nullable = false)
  private Long courseId;   // <-- back to primitive


  private Instant startedAt = Instant.now();
  private Instant completedAt;
  private Integer progressPct = 0;
}
