DROP TABLE students;
DROP TABLE houses;

CREATE TABLE houses (
  id SERIAL8 PRIMARY KEY,
  logo_url VARCHAR(255),
  name VARCHAR(255)
);

CREATE TABLE students (
  id SERIAL8 PRIMARY KEY,
  first_name VARCHAR(255),
  last_name VARCHAR(255),
  portrait_url VARCHAR(255),
  age INT4,
  house_id INT4 REFERENCES houses(id)
);

