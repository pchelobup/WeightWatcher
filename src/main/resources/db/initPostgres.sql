DROP TABLE IF EXISTS notation;
DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START WITH 1000;


CREATE TABLE users
(
    id             int primary key DEFAULT nextval('global_seq'),
    email          varchar(30)      not null unique,
    password       varchar(30)      not null,
    registered     timestamp       default now(),
    gender         varchar(6),
    height         int              not null,
    age            int              not null,
    activity       varchar(6)       not null,
    start_weight   double precision not null,
    desired_weight double precision not null,
    calories       int

);

CREATE TABLE notation
(
    id      int primary key DEFAULT nextval('global_seq'),
    user_id int              not null,
    added   date             not null,
    weight  double precision not null,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
)

