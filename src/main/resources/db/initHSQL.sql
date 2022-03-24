DROP TABLE IF EXISTS notation;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS GLOBAL_SEQ;

CREATE SEQUENCE GLOBAL_SEQ AS INTEGER START WITH 1000;


CREATE TABLE users
(
    id             INTEGER GENERATED BY DEFAULT AS SEQUENCE GLOBAL_SEQ PRIMARY KEY,
    email          varchar(30)      not null unique,
    password       varchar(30)      not null,
    registered     timestamp default now(),
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
    id      INTEGER GENERATED BY DEFAULT AS SEQUENCE GLOBAL_SEQ PRIMARY KEY,
    user_id int              not null,
    added   date             not null,
    weight  double precision not null,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
)

