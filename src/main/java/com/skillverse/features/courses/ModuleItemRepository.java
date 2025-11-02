package com.skillverse.features.courses;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModuleItemRepository extends JpaRepository<ModuleItem, Long> {
    List<ModuleItem> findByCourseIdOrderByOrderIndexAsc(Long courseId);
  }