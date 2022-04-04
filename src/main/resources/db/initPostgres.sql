DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS notation;
DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START WITH 1000;


CREATE TABLE users
(
    id             INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    email          VARCHAR(30)      NOT NULL UNIQUE,
    password       VARCHAR     NOT NULL,
    registered     TIMESTAMP           DEFAULT now() NOT NULL,
    gender         VARCHAR(6),
    height         INTEGER,
    age            INTEGER,
    activity       VARCHAR(6),
    start_weight   DOUBLE PRECISION,
    desired_weight DOUBLE PRECISION,
    calories       INTEGER


);

CREATE TABLE user_roles
(
    user_id INTEGER NOT NULL,
    role    VARCHAR,
    CONSTRAINT user_roles_idx UNIQUE (user_id, role),
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE notation
(
    id      INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    user_id INTEGER          NOT NULL,
    added   DATE             NOT NULL,
    weight  DOUBLE PRECISION NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
)

