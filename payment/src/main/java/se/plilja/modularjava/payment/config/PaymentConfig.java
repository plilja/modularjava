package se.plilja.modularjava.payment.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;

@Slf4j
@PropertySource("/payment/application.properties")
@ComponentScan("se.plilja.modularjava.payment")
@Configuration
public class PaymentConfig {
    @Value("${payment.some-property}") int someProperty;

    @PostConstruct
    public void logProperty() {
        log.info("Property read [value={}]", someProperty);
    }
}

