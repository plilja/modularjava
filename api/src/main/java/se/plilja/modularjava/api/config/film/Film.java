package se.plilja.modularjava.api.config.film;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@Data
public class Film {
    private Long filmId;
    private String title;
    private Genre genre;
    private int lengthMinutes;
    private BigDecimal rating;
}
