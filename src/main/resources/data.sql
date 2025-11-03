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
-- Each module belongs to a course_id (1–5 from your courses table)
INSERT INTO course_modules (title, order_index, course_id) VALUES
('Introduction to AI', 1, 1),
('AI Tools Overview', 2, 1),
('Data Cleaning Basics', 1, 2),
('Visualization with Power BI', 2, 2),
('Supervised vs Unsupervised ML', 1, 3),
('Model Evaluation', 2, 3),
('Dashboard Design', 1, 4),
('Storytelling with Data', 2, 4),
('Communication Skills', 1, 5),
('Team Collaboration', 2, 5);

-- Attach to module_id from the above list (1–10)
INSERT INTO lessons (title, type, content_url, transcript, order_index, duration_sec, module_id) VALUES
('What is Artificial Intelligence?', 'VIDEO', 'https://youtu.be/sample-ai', 'Basics of AI', 1, 300, 1),
('History of AI', 'PDF', 'https://example.com/history.pdf', 'Timeline of AI evolution', 2, 180, 1),
('AI Tools Demo', 'VIDEO', 'https://youtu.be/sample-tools', 'Demo of modern AI tools', 1, 420, 2),
('Cleaning Data with Excel', 'VIDEO', 'https://youtu.be/sample-clean', 'Hands-on demo for cleaning data', 1, 360, 3),
('Creating Charts in Power BI', 'VIDEO', 'https://youtu.be/sample-bi', 'Visualization tips', 1, 480, 4),
('Supervised Learning Basics', 'VIDEO', 'https://youtu.be/sample-ml', 'Regression and classification', 1, 420, 5),
('Confusion Matrix Explained', 'PDF', 'https://example.com/confusion.pdf', 'Understanding confusion matrix', 1, 180, 6),
('Designing Dashboards', 'VIDEO', 'https://youtu.be/sample-dash', 'Power BI dashboard design', 1, 400, 7),
('Data Storytelling Principles', 'VIDEO', 'https://youtu.be/sample-story', 'Turning data into insights', 1, 420, 8),
('Effective Communication', 'VIDEO', 'https://youtu.be/sample-comm', 'Improving communication skills', 1, 300, 9);


-- Each quiz belongs to a lesson_id
INSERT INTO quizzes (title, total_points, lesson_id) VALUES
('AI Fundamentals Quiz', 10, 1),
('AI Tools Quiz', 10, 3),
('Data Cleaning Quiz', 10, 4),
('Visualization Quiz', 10, 5),
('Machine Learning Quiz', 10, 6);


-- Each question belongs to a quiz_id
INSERT INTO quiz_questions (quiz_id, stem, options_json, answer_key, points) VALUES
(1, 'Which of these is an AI application?', '["Spreadsheet","ChatGPT","Calculator","Email Client"]', 'ChatGPT', 2),
(1, 'AI stands for?', '["Artificial Intelligence","Applied Inference","Auto Integration","Analytic Insight"]', 'Artificial Intelligence', 2),
(2, 'Power BI is used for?', '["Image Editing","Data Visualization","Web Hosting","Coding"]', 'Data Visualization', 2),
(3, 'What is data cleaning?', '["Removing nulls","Adding noise","Encrypting data","Deleting schema"]', 'Removing nulls', 2),
(4, 'Which chart shows trends over time?', '["Bar","Pie","Line","Scatter"]', 'Line', 2),
(5, 'Supervised learning requires?', '["Labeled data","Unlabeled data","No data","Manual rules"]', 'Labeled data', 2);


-- Pretend user_id 1–3 are test users; course_id from 1–5
INSERT INTO enrollments (user_id, course_id, started_at, completed_at, progress_pct) VALUES
(1, 1, NOW(), NULL, 40),
(1, 2, NOW(), NULL, 20),
(2, 3, NOW(), NOW(), 100),
(3, 4, NOW(), NULL, 60),
(2, 5, NOW(), NULL, 30);


-- Link to user_id & course_id that are completed
--INSERT INTO certificates (user_id, course_id, issued_at, pdf_url, serial) VALUES
--(2, 3, NOW(), 'https://example.com/certificates/ml101.pdf', 'CERT-ML101-2025-0001'),
--(3, 4, NOW(), 'https://example.com/certificates/powerbi.pdf', 'CERT-PBI-2025-0002');


