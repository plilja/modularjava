package se.plilja.modularjava.film.films;

import lombok.Data;
import se.plilja.modularjava.api.config.film.Genre;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Table(name = "FILM", schema = "FILM")
@Entity
public class FilmEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(name = "GENRE", nullable = false)
    private Genre genre;

    @Column(name = "LENGTH_MINUTES", nullable = false)
    private int lengthMinutes;

    @Column(name = "RATING", nullable = false)
    private BigDecimal rating;

    @Column(name = "CREATED", nullable = false)
    private LocalDateTime created;
}
