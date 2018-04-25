CREATE DATABASE shop;
USE shop;

CREATE TABLE user (
  user_id     INT           NOT NULL  AUTO_INCREMENT,
  first_name  VARCHAR(50)   NOT NULL,
  last_name   VARCHAR(50)   NOT NULL,
  email       VARCHAR(100)  NOT NULL  UNIQUE,
  birthday    DATE          NOT NULL,
  password    VARCHAR(100)  NOT NULL,
  photo       VARCHAR(300),

  PRIMARY KEY (user_id)
);

CREATE TABLE role (
  role_id   INT         NOT NULL AUTO_INCREMENT,
  role_name VARCHAR(50) NOT NULL UNIQUE,

  PRIMARY KEY (role_id)
);

CREATE TABLE user_roles (
  user_id INT   NOT NULL,
  role_id INT   NOT NULL,

  FOREIGN KEY (user_id) REFERENCES user(user_id),
  FOREIGN KEY (role_id) REFERENCES role(role_id)
);

INSERT INTO
user(first_name, last_name, email, birthday, password, photo)
VALUES ('Siarhei', 'Blashuk', 'bloshuk74@gmail.com', '1996-7-18', '$2a$10$/CtHaeqRzguwG72Ssz.eNuyiRZQiOuHoRYiNa.RcyVq92EBYfzcmS', 'https://avatars0.githubusercontent.com/u/22153744?s=400&u=4b7d4a59f0c4b230433682fc6544ecdf02ce88b3&v=4');

INSERT INTO role (role_name) VALUES ('USER'), ('ADMIN');

INSERT INTO
  user_roles (user_id, role_id)
VALUES
  ((SELECT user_id
    FROM user
    WHERE email = 'bloshuk74@gmail.com'), (SELECT role_id
                                           FROM role
                                           WHERE role_name = 'ADMIN')),
  ((SELECT user_id
    FROM user
    WHERE email = 'bloshuk74@gmail.com'), (SELECT role_id
                                           FROM role
                                           WHERE role_name = 'USER'));

CREATE TABLE common_category (
  common_category_id INT          NOT NULL AUTO_INCREMENT,
  name               VARCHAR(100) NOT NULL UNIQUE,

  PRIMARY KEY (common_category_id)
);

CREATE TABLE category (
  category_id        INT          NOT NULL AUTO_INCREMENT,
  name               VARCHAR(100) NOT NULL UNIQUE,
  common_category_id INT          NOT NULL,

  PRIMARY KEY (category_id),
  FOREIGN KEY (common_category_id) REFERENCES common_category (common_category_id)
);

INSERT INTO common_category (name) VALUES ('Electronic devices');
INSERT INTO category (name, common_category_id)
VALUES
  ('Computer', (SELECT common_category_id
                      FROM common_category
                      WHERE name = 'Electronic devices')),
  ('Keyboard', (SELECT common_category_id
                 FROM common_category
                 WHERE name = 'Electronic devices')),
  ('Printer', (SELECT common_category_id
                 FROM common_category
                 WHERE name = 'Electronic devices')),
  ('Smartphone', (SELECT common_category_id
                 FROM common_category
                 WHERE name = 'Electronic devices'));