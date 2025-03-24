package com.example.customer;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class CustomerService {
  private final CustomerRepository customerRepository;
  private final RestClient restClient;

  public CustomerService(CustomerRepository customerRepository, RestClient restClient) {
    this.customerRepository = customerRepository;
    this.restClient = restClient;
  }

  public void registerCustomer(CustomerRegistrationRequest request) {
    var customer = Customer.of(
        request.firstName(),
        request.lastName(),
        request.email()
    );
    customerRepository.save(customer);
    var body = restClient.get().uri("http://fraud/api/v1/fraud-check/" + customer.getId())
            .retrieve()
            .body(FraudCheckResponse.class);

    assert body != null;
    if (body.isFraudulent()) {
      throw new IllegalStateException("Fraudulent customer");
    }
  }
}

record FraudCheckResponse(boolean isFraudulent) {
}
