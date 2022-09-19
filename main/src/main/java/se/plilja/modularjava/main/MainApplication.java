package se.plilja.modularjava.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import se.plilja.modularjava.api.config.ApiConfig;
import se.plilja.modularjava.common.config.CommonConfig;
import se.plilja.modularjava.customer.config.CustomerConfig;
import se.plilja.modularjava.film.config.FilmConfig;
import se.plilja.modularjava.payment.config.PaymentConfig;

@Import({
        ApiConfig.class,
        CommonConfig.class,
        ApiConfig.class,
        PaymentConfig.class,
        CustomerConfig.class,
        FilmConfig.class
})
@EnableAutoConfiguration
@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }
}
