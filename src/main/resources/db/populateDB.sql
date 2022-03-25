DELETE FROM notation;
DELETE FROM user_roles;
DELETE FROM users;

INSERT INTO users(id, email, password, registered, gender, height, age, activity, start_weight, desired_weight, calories)
VALUES (1, 'mail@Mail.com', '$2a$12$60FfYkS5N6zC8bQ2NYLw8uOWYBd5XEP6oQ69pweZzVKj.Bo0YbJ3y', '2020-01-30 10:00:00', 'MALE', 180, 55, 'MIN', 100, 90, 2000),
       (2, 'pochta@Mail.com', '$2a$12$h5yDKri/.IjvfHrziaQ.QejnQmhSKmEXg4zHq6CVGM5IWkr.GiqPG', '2022-01-30 10:00:00', 'FEMALE', 150, 16, 'MIN', 55, 40, 1000);

INSERT INTO user_roles(user_id, role)
VALUES (1, 'USER'),
       (2, 'USER');

INSERT INTO notation(id, user_id, added, weight)
VALUES (3, 1, '2020-01-30', 100.1),
       (4, 1, '2020-01-31', 99.4),
       (5, 2, '2022-01-31', 54.9),
       (6, 2, '2022-02-01', 54.6),
       (7, 2, '2022-02-02', 54.7);