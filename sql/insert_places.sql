CREATE SEQUENCE adding_sits
START 1
INCREMENT 1
MINVALUE 1
MAXVALUE 30
OWNED BY Place.seat
CYCLE;

INSERT INTO Place(seat, sector, row, state)
VALUES (nextval('adding_sits'), 'A' ,1 ,0);

