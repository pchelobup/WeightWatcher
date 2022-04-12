DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS notation;
DROP TABLE IF EXISTS user_parameters;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS GLOBAL_SEQ;

CREATE SEQUENCE GLOBAL_SEQ AS BIGINT START WITH 1000;


CREATE TABLE users
(
    id         BIGINT GENERATED BY DEFAULT AS SEQUENCE GLOBAL_SEQ PRIMARY KEY,
    email      VARCHAR(30)             NOT NULL UNIQUE,
    password   VARCHAR(1000)           NOT NULL,
    registered TIMESTAMP DEFAULT now() NOT NULL,
    status     VARCHAR(10)             NOT NULL

);

CREATE TABLE parameters
(
    id             BIGINT GENERATED BY DEFAULT AS SEQUENCE GLOBAL_SEQ PRIMARY KEY,
    user_id        BIGINT NOT NULL UNIQUE,
    gender         VARCHAR(6),
    height         INTEGER,
    age            INTEGER,
    activity       VARCHAR(6),
    start_weight   DOUBLE PRECISION,
    desired_weight DOUBLE PRECISION,
    calories       INTEGER,
    FOREIGN KEY (user_id) REFERENCES USERS (id) ON DELETE CASCADE
);

CREATE TABLE user_roles
(
    user_id BIGINT NOT NULL,
    role    VARCHAR(255),
    CONSTRAINT user_roles_idx UNIQUE (user_id, role),
    FOREIGN KEY (user_id) REFERENCES USERS (id) ON DELETE CASCADE
);

CREATE TABLE notation
(
    id      BIGINT GENERATED BY DEFAULT AS SEQUENCE GLOBAL_SEQ PRIMARY KEY,
    user_id BIGINT NOT NULL,
    added   DATE   NOT NULL,
    weight  DOUBLE NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
)

