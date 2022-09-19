package se.plilja.modularjava.api.config.customer;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Customer {
    private Long customerId;
    private String ssn;
    private String username;
    private String firstName;
    private String lastName;
    private String phoneNumber;
}
