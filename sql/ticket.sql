CREATE TABLE Place (
    place_id SERIAL PRIMARY KEY,
    seat INT,
    sector VARCHAR(2),
    row INT,
    state INT
);

CREATE TABLE Ticket (
    ticket_id SERIAL PRIMARY KEY,
    event_name VARCHAR(255) NOT NULL,
    event_date Date NOT NULL,
    description VARCHAR (255),
    code VARCHAR(255),
    last_update DATE,
    place_id INT NOT NULL UNIQUE,
    CONSTRAINT fk_place
        FOREIGN KEY (place_id)
        REFERENCES Place(place_id)
);
