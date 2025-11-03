-- Clean up (optional; remove if you want to preserve data)
-- DROP TABLE IF EXISTS courses CASCADE;

-- Insert dummy courses
INSERT INTO courses (id, title, subtitle, level, modules_count, status, created_at)
VALUES
  (1, 'AI Fundamentals', 'Introduction to Artificial Intelligence concepts', 'BEGINNER', 8, 'PUBLISHED', NOW()),
  (2, 'Data Analytics Essentials', 'Learn how to analyze and visualize data effectively', 'INTERMEDIATE', 10, 'PUBLISHED', NOW()),
  (3, 'Machine Learning for Beginners', 'A hands-on introduction to ML algorithms', 'BEGINNER', 6, 'DRAFT', NOW()),
  (4, 'Advanced Power BI Dashboarding', 'Create interactive dashboards for real-world insights', 'ADVANCED', 5, 'PUBLISHED', NOW()),
  (5, 'Soft Skills Masterclass', 'Improve communication and teamwork abilities', 'BEGINNER', 4, 'PUBLISHED', NOW());

-- You can extend this later to seed other tables when they exist
-- For example:
-- INSERT INTO lessons (id, title, type, content_url, transcript, order_index, duration_sec, module_id)
-- VALUES (1, 'Intro to AI', 'VIDEO', 'https://youtu.be/sample', 'This lesson explains basics of AI...', 1, 300, 1);
