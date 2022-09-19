package se.plilja.modularjava.film.films;

import org.springframework.stereotype.Service;
import se.plilja.modularjava.api.config.film.Film;

import java.time.LocalDateTime;

@Service
public class FilmConverter {

    public Film fromEntity(FilmEntity filmEntity) {
        Film film = new Film();
        film.setFilmId(filmEntity.getId());
        film.setTitle(filmEntity.getTitle());
        film.setGenre(filmEntity.getGenre());
        film.setLengthMinutes(filmEntity.getLengthMinutes());
        film.setRating(filmEntity.getRating());
        return film;
    }

    public FilmEntity toEntity(Film film) {
        FilmEntity filmEntity = new FilmEntity();
        filmEntity.setRating(film.getRating());
        filmEntity.setLengthMinutes(film.getLengthMinutes());
        filmEntity.setTitle(film.getTitle());
        filmEntity.setGenre(film.getGenre());
        return filmEntity;
    }

}
