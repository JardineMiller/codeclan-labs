1.  Using an inner join, select the flight number and airport name for all the flights

```
SELECT flights.number, airports.name FROM flights
INNER JOIN airports
ON flights.airport_id = airports.id
```

2. Add aliases so that the resulting columns are called flight_number and airport_name

```
SELECT flights.number AS flight_number, airports.name AS airport_name FROM flights
INNER JOIN airports
ON flights.airport_id = airports.id
```

3. Using an inner join, select the flight number and airport name for all the flights that belong to Heathrow

```
SELECT flights.number AS flight_number, airports.name AS airport_name FROM flights
INNER JOIN airports
ON flights.airport_id = airports.id
WHERE airports.name = 'Heathrow'
```

4. Using an inner join, select all the flight and airport details for flight BA1453

```
SELECT flights.number, airports.name, airports.city, airports.runways, airports.airport_type FROM flights
INNER JOIN airports
ON flights.airport_id = airports.id
WHERE flights.number = 'BA1453'
```

5. Using inner joins, select the flight number of the flights that Tom Cruise is on.

```
SELECT flights.number FROM flights
INNER JOIN passengers_flights
ON passengers_flights.flight_id = flights.id
INNER JOIN passengers
ON passengers_flights.passenger_id = passengers.id
WHERE passengers.first_name = 'Tom' AND passengers.last_name = 'Cruise'
```

6. Using inner joins, select all of Sian's flight numbers and all of Tom's flight numbers (NOTE: you'll have to us some brackets in the where clause to separate your ANDs and ORs)

```
SELECT flights.number, passengers.first_name FROM flights
INNER JOIN passengers_flights
ON passengers_flights.flight_id = flights.id
INNER JOIN passengers
ON passengers_flights.passenger_id = passengers.id
WHERE (passengers.first_name = 'Tom' AND passengers.last_name = 'Cruise') OR (passengers.first_name = 'Sian' AND passengers.last_name = 'RD')
```

7. What changes would you make to the structure of the flights table so that we can identify a flight's departure and destination airports? 

Create an additional column as a DESTINATION ID (assuming the Aiport ID is the DEPARTURE ID)
