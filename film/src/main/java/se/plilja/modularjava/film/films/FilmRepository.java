package se.plilja.modularjava.film.films;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends PagingAndSortingRepository<FilmEntity, Long> {
}
