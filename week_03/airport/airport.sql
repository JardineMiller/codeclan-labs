DROP TABLE airports;
DROP TABLE flights;
DROP TABLE passengers;
DROP TABLE passengers_flights;

CREATE TABLE airports
(
  id SERIAL8 PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  city VARCHAR(255),
  runways INT,
  airport_type VARCHAR(255)
);

CREATE TABLE flights
(
  id SERIAL8 PRIMARY KEY,
  number VARCHAR(255) NOT NULL,
  airport_id INT8 REFERENCES airports(id)
);

CREATE TABLE passengers
(
  id SERIAL8 PRIMARY KEY,
  first_name VARCHAR(255),
  last_name VARCHAR(255),
  address VARCHAR(255)
);

CREATE TABLE passengers_flights
(
  id SERIAL8 PRIMARY KEY,
  passenger_id INT8 REFERENCES passengers(id),
  flight_id INT8 REFERENCES flights(id)
);


INSERT INTO airports (name, city, runways, airport_type) VALUES ('Heathrow', 'London', 3, 'international');
INSERT INTO airports (name, city, runways, airport_type) VALUES ('Edinburgh','Edinburgh', 1, 'international');
INSERT INTO airports (name, city, runways, airport_type) VALUES ('JFK','New York', 4, 'international');

INSERT INTO flights (number, airport_id) VALUES ('BA1453', 1);
INSERT INTO flights (number, airport_id) VALUES ('EJ6796', 1);
INSERT INTO flights (number, airport_id) VALUES ('RY786', 2);
INSERT INTO flights (number, airport_id) VALUES ('SY78', 3);

INSERT INTO passengers (first_name, last_name, address) VALUES ('Sian', 'RD', 'Edinburgh');
INSERT INTO passengers (first_name, last_name, address) VALUES ('Upul', 'Dissanayaka', 'Edinburgh');
INSERT INTO passengers (first_name, last_name, address) VALUES ('Tom', 'Cruise','Los Angeles');
INSERT INTO passengers (first_name, last_name, address) VALUES ('Chuck', 'Berry', 'Saint Louis');
INSERT INTO passengers (first_name, last_name, address) VALUES ('Sara', 'Montague', 'London');

INSERT INTO passengers_flights (passenger_id, flight_id) VALUES (1, 1);
INSERT INTO passengers_flights (passenger_id, flight_id) VALUES (1, 2);
INSERT INTO passengers_flights (passenger_id, flight_id) VALUES (2, 2);
INSERT INTO passengers_flights (passenger_id, flight_id) VALUES (2, 4);
INSERT INTO passengers_flights (passenger_id, flight_id) VALUES (1, 3);
INSERT INTO passengers_flights (passenger_id, flight_id) VALUES (3, 1);
INSERT INTO passengers_flights (passenger_id, flight_id) VALUES (4, 1);
INSERT INTO passengers_flights (passenger_id, flight_id) VALUES (5, 3);
INSERT INTO passengers_flights (passenger_id, flight_id) VALUES (3, 3);