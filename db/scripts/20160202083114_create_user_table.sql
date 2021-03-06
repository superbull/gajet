-- // create user table
-- Migration SQL that makes the change goes here.

CREATE TABLE app_user (
id            INT(11)      NOT NULL AUTO_INCREMENT PRIMARY KEY,
username      VARCHAR(25),
email         VARCHAR(255),
mobile        VARCHAR(20),
password      VARCHAR(255),
created_at    DATETIME,
last_login_at DATETIME
);

ALTER TABLE app_user
    ADD CONSTRAINT app_user_uk_email
    UNIQUE (email),

    ADD CONSTRAINT app_user_uk_mobile
    UNIQUE (mobile);

-- //@UNDO
-- SQL to undo the change goes here.

DROP TABLE app_user;
