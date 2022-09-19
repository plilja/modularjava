package se.plilja.modularjava.film.films;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import se.plilja.modularjava.api.config.film.Film;
import se.plilja.modularjava.common.request.CommonRequestParams;
import se.plilja.modularjava.common.request.Paginated;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/film")
class FilmController {
    private final FilmRepository filmRepository;
    private final FilmConverter filmConverter;

    @GetMapping("")
    Paginated<Film> getFilms(
            @RequestParam(CommonRequestParams.PAGE_NUMBER) int pageNumber,
            @RequestParam(CommonRequestParams.PAGE_SIZE) int pageSize
    ) {
        Page<FilmEntity> pageEntities = filmRepository.findAll(Pageable.ofSize(pageSize).withPage(pageNumber));
        Page<Film> pageFilms = pageEntities.map(filmConverter::fromEntity);
        return Paginated.fromPage(pageFilms);
    }

    @GetMapping("/{id}")
    Film getFilmById(@RequestParam("id") long id) {
        return filmRepository.findById(id)
                .map(filmConverter::fromEntity)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("")
    Film saveFilm(@RequestBody Film film) {
        FilmEntity newEntity = filmConverter.toEntity(film);
        newEntity.setCreated(LocalDateTime.now());
        FilmEntity saveEntity = filmRepository.save(newEntity);
        return filmConverter.fromEntity(saveEntity);
    }

}
