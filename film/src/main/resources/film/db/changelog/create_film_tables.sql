CREATE SCHEMA FILM;

CREATE TABLE FILM.GENRE(
    ID VARCHAR(30) NOT NULL PRIMARY KEY
);

CREATE TABLE FILM.FILM(
    ID IDENTITY NOT NULL PRIMARY KEY,
    TITLE VARCHAR(255) NOT NULL,
    GENRE VARCHAR(30) NOT NULL,
    LENGTH_MINUTES SMALLINT,
    RATING NUMERIC(4, 2),
    CREATED TIMESTAMP NOT NULL
);

ALTER TABLE FILM.FILM
ADD FOREIGN KEY (GENRE)
REFERENCES FILM.GENRE(ID);

INSERT INTO FILM.GENRE (ID) VALUES ('ACTION');
INSERT INTO FILM.GENRE (ID) VALUES ('DRAMA');
INSERT INTO FILM.GENRE (ID) VALUES ('THRILLER');
INSERT INTO FILM.GENRE (ID) VALUES ('COMEDY');
INSERT INTO FILM.GENRE (ID) VALUES ('DOCUMENTARY');

INSERT INTO FILM.FILM (TITLE, GENRE, LENGTH_MINUTES, RATING, CREATED) VALUES ('Die Hard', 'ACTION', 132, 8.2, CURRENT_TIMESTAMP());
INSERT INTO FILM.FILM (TITLE, GENRE, LENGTH_MINUTES, RATING, CREATED) VALUES ('Shindler''s List', 'DRAMA', 195, 9.0, CURRENT_TIMESTAMP());
INSERT INTO FILM.FILM (TITLE, GENRE, LENGTH_MINUTES, RATING, CREATED) VALUES ('Heat', 'THRILLER', 170, 8.0, CURRENT_TIMESTAMP());
INSERT INTO FILM.FILM (TITLE, GENRE, LENGTH_MINUTES, RATING, CREATED) VALUES ('The Mask', 'COMEDY', 101, 7.1, CURRENT_TIMESTAMP());
INSERT INTO FILM.FILM (TITLE, GENRE, LENGTH_MINUTES, RATING, CREATED) VALUES ('Free Solo', 'DOCUMENTARY', 100, 8.1, CURRENT_TIMESTAMP());