package se.plilja.modularjava.common.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ComponentScan("se.plilja.modularjava.common")
@Configuration
@EnableJpaRepositories("se.plilja.modularjava")
@EntityScan("se.plilja.modularjava")
@EnableTransactionManagement
public class CommonConfig {
}
