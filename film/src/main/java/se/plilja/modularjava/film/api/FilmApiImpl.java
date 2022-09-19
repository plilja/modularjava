package se.plilja.modularjava.film.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import se.plilja.modularjava.api.config.film.Film;
import se.plilja.modularjava.api.config.film.FilmApi;
import se.plilja.modularjava.film.films.FilmConverter;
import se.plilja.modularjava.film.films.FilmRepository;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
class FilmApiImpl implements FilmApi {
    private final FilmRepository filmRepository;
    private final FilmConverter filmConverter;

    @Override
    public Film getFilm(long filmId) throws NoSuchElementException {
        return filmRepository.findById(filmId)
                .map(filmConverter::fromEntity)
                .orElseThrow(() -> new NoSuchElementException("Film with id %d not found".formatted(filmId)));
    }
}
