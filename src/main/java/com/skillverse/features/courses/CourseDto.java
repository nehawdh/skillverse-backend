package com.skillverse.features.courses;

import java.time.Instant;

public record CourseDto(Long id, String title, String subtitle,
                        String level, Integer modulesCount, String status, Instant createdAt) {}
