package se.plilja.modularjava.customer.api;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import se.plilja.modularjava.api.config.customer.Customer;
import se.plilja.modularjava.api.config.customer.CustomerApi;
import se.plilja.modularjava.customer.customers.CustomerConverter;
import se.plilja.modularjava.customer.customers.CustomerRepository;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
class CustomerApiImpl implements CustomerApi {
    private final CustomerRepository customerRepository;
    private final CustomerConverter customerConverter;

    @Override
    public Customer getCustomer(long customerId) throws NoSuchElementException {
        return customerRepository.findById(customerId)
                .map(customerConverter::fromEntity)
                .orElseThrow(() -> new NoSuchElementException("Customer with id %d not found".formatted(customerId)));
    }
}
