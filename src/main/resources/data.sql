INSERT INTO "user" (id, name)
VALUES
    (1, 'Jarkynbyek Japar'),
    (2, 'Alice Johnson'),
    (3, 'Bob Smith'),
    (4, 'Charlie Davis'),
    (5, 'Diana Roberts');

INSERT INTO "post" (id, user_id, author, content, title)
VALUES
    (1, 1, 'Jarkynbyek Japar', 'Hello World!', 'Hello World!'),
    (2, 2, 'Alice Johnson', 'My first blog post', 'Introduction'),
    (3, 3, 'Bob Smith', 'Thoughts on technology', 'Tech Trends'),
    (4, 4, 'Charlie Davis', 'A day in my life', 'Daily Journal'),
    (5, 5, 'Diana Roberts', 'How to stay motivated', 'Motivation Tips'),
    (6, 1, 'Jarkynbyek Japar', 'Database optimization techniques', 'SQL Best Practices'),
    (7, 2, 'Alice Johnson', 'Why I love programming', 'Coding Passion'),
    (8, 3, 'Bob Smith', 'The future of AI', 'Artificial Intelligence'),
    (9, 4, 'Charlie Davis', 'Traveling the world', 'Wanderlust'),
    (10, 5, 'Diana Roberts', 'Healthy eating habits', 'Nutrition Guide'),
    (11, 1, 'Jarkynbyek Japar', 'Learning a new language', 'Language Journey');

INSERT INTO "comment" (id, post_id, name)
VALUES
    (1, 1, 'Great post!'),
    (2, 1, 'Nice to see your first post!'),
    (3, 1, 'Looking forward to more content!'),
    (4, 1, 'Interesting thoughts!'),
    (5, 1, 'Keep it up!'),
    (6, 2, 'Very insightful!'),
    (7, 2, 'Thanks for sharing!'),
    (8, 2, 'Love this!'),
    (9, 2, 'Great introduction!'),
    (10, 2, 'Keep writing!'),
    (11, 3, 'Tech trends are fascinating!'),
    (12, 3, 'Good perspective!'),
    (13, 3, 'I agree with your points!'),
    (14, 3, 'More tech posts please!'),
    (15, 3, 'Very well written!'),
    (16, 4, 'Nice daily journal!'),
    (17, 4, 'Relatable content!'),
    (18, 4, 'Thanks for sharing your day!'),
    (19, 4, 'I enjoyed reading this!'),
    (20, 4, 'Great routine!'),
    (21, 5, 'Motivation is key!'),
    (22, 5, 'Really inspiring!'),
    (23, 5, 'Good tips!'),
    (24, 5, 'Helped me a lot!'),
    (25, 5, 'Keep motivating us!');

SELECT setval('user_id_seq', (SELECT MAX(id) FROM "user"));
SELECT setval('post_id_seq', (SELECT MAX(id) FROM "post"));
SELECT setval('comment_id_seq', (SELECT MAX(id) FROM "comment"));