package se.plilja.modularjava.film.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@ComponentScan("se.plilja.modularjava.film")
@PropertySource("/film/application.properties")
@Configuration
public class FilmConfig {
}
