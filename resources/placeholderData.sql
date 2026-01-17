TRUNCATE ticket_entity, flight_entity, passenger_entity, airline_entity RESTART IDENTITY;

INSERT INTO airline_entity (name) VALUES
                                      ('LOT Polish Airlines'),
                                      ('Lufthansa'),
                                      ('Ryanair'),
                                      ('Emirates'),
                                      ('Qatar Airways');

INSERT INTO passenger_entity (first_name, last_name) VALUES
                                                         ('Jan', 'Kowalski'),
                                                         ('Anna', 'Nowak'),
                                                         ('Robert', 'Lewandowski'),
                                                         ('Maria', 'Wiśniewska'),
                                                         ('Piotr', 'Zieliński'),
                                                         ('Katarzyna', 'Wójcik'),
                                                         ('Marek', 'Kamiński'),
                                                         ('Magdalena', 'Lewandowska');

-- Zakładamy, że ID linii lotniczych to 1-5
INSERT INTO flight_entity (flight_number, origin, destination, price, available_seats, airline_id) VALUES
                                                                                                       ('LO391', 'Warszawa (WAW)', 'Kraków (KRK)', 250.00, 50, 1),
                                                                                                       ('LH123', 'Frankfurt (FRA)', 'Nowy Jork (JFK)', 2400.00, 120, 2),
                                                                                                       ('FR241', 'Londyn (STN)', 'Barcelona (BCN)', 89.99, 180, 3),
                                                                                                       ('EK007', 'Dubaj (DXB)', 'Paryż (CDG)', 3500.00, 300, 4),
                                                                                                       ('QR015', 'Doha (DOH)', 'Warszawa (WAW)', 2800.00, 250, 5),
                                                                                                       ('LO101', 'Warszawa (WAW)', 'Londyn (LHR)', 450.00, 80, 1);

INSERT INTO ticket_entity (purchase_date, passenger_id, flight_id) VALUES
                                                                       (CURRENT_TIMESTAMP - INTERVAL '2 days', 1, 1),
                                                                       (CURRENT_TIMESTAMP - INTERVAL '1 day', 2, 1),
                                                                       (CURRENT_TIMESTAMP - INTERVAL '5 hours', 3, 2),
                                                                       (CURRENT_TIMESTAMP - INTERVAL '10 days', 4, 3),
                                                                       (CURRENT_TIMESTAMP - INTERVAL '1 hour', 5, 4),
                                                                       (CURRENT_TIMESTAMP - INTERVAL '3 days', 6, 5),
                                                                       (CURRENT_TIMESTAMP - INTERVAL '12 hours', 7, 6),
                                                                       (CURRENT_TIMESTAMP - INTERVAL '20 minutes', 8, 6);