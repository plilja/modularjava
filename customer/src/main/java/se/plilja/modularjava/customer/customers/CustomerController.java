package se.plilja.modularjava.customer.customers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import se.plilja.modularjava.api.config.customer.Customer;
import se.plilja.modularjava.common.request.CommonRequestParams;
import se.plilja.modularjava.common.request.Paginated;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
class CustomerController {
    private final CustomerRepository customerRepository;
    private final CustomerConverter customerConverter;

    @GetMapping("")
    Paginated<Customer> getCustomers(
            @RequestParam(CommonRequestParams.PAGE_NUMBER) int pageNumber,
            @RequestParam(CommonRequestParams.PAGE_SIZE) int pageSize
    ) {
        Page<CustomerEntity> pageEntities = customerRepository.findAll(Pageable.ofSize(pageSize).withPage(pageNumber));
        Page<Customer> pageCustomers = pageEntities.map(customerConverter::fromEntity);
        return Paginated.fromPage(pageCustomers);
    }

    @GetMapping("/{id}")
    Customer getCustomerById(@RequestParam("id") long id) {
        return customerRepository.findById(id)
                .map(customerConverter::fromEntity)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("")
    Customer createCustomer(@RequestBody Customer customer) {
        CustomerEntity newEntity = customerConverter.toEntity(customer);
        newEntity.setCreated(LocalDateTime.now());
        CustomerEntity savedEntity = customerRepository.save(newEntity);
        return customerConverter.fromEntity(savedEntity);
    }

}
