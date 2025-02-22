package com.example.customer;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {
  private final CustomerRepository customerRepository;

  public CustomerService(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  public void registerCustomer(CustomerRegistrationRequest request) {
    var customer = Customer.of(
        request.firstName(),
        request.lastName(),
        request.email()
    );
    customerRepository.save(customer);
  }
}
