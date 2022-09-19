package se.plilja.modularjava.api.config.customer;

import java.util.NoSuchElementException;

public interface CustomerApi {
    Customer getCustomer(long customerId) throws NoSuchElementException;
}
