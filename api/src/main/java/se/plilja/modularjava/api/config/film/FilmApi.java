package se.plilja.modularjava.api.config.film;

import java.util.NoSuchElementException;

public interface FilmApi {
    Film getFilm(long filmId) throws NoSuchElementException;
}
