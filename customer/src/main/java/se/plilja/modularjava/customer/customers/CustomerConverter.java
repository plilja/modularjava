package se.plilja.modularjava.customer.customers;

import org.springframework.stereotype.Service;
import se.plilja.modularjava.api.config.customer.Customer;

@Service
public class CustomerConverter {
    public Customer fromEntity(CustomerEntity customerEntity) {
        Customer customer = new Customer();
        customer.setCustomerId(customerEntity.getId());
        customer.setSsn(customerEntity.getSsn());
        customer.setFirstName(customerEntity.getFirstName());
        customer.setLastName(customerEntity.getLastName());
        customer.setUsername(customerEntity.getUsername());
        customer.setPhoneNumber(customerEntity.getPhoneNumber());
        return customer;
    }

    public CustomerEntity toEntity(Customer customer) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId(customerEntity.getId());
        customerEntity.setSsn(customerEntity.getSsn());
        customerEntity.setFirstName(customerEntity.getFirstName());
        customerEntity.setLastName(customerEntity.getLastName());
        customerEntity.setUsername(customerEntity.getUsername());
        customerEntity.setPhoneNumber(customerEntity.getPhoneNumber());
        return customerEntity;
    }
}
