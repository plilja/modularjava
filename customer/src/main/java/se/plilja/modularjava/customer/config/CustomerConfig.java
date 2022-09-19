package se.plilja.modularjava.customer.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@ComponentScan("se.plilja.modularjava.customer")
@PropertySource("/customer/application.properties")
@Configuration
public class CustomerConfig {
}
