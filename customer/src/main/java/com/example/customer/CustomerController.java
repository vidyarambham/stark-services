package com.example.customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {
  private final Logger log = LoggerFactory.getLogger(CustomerController.class);
  private final CustomerService customerService;

  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @PostMapping
  public void  registerCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest) {
    log.info("Registering customer: {}", customerRegistrationRequest);
    customerService.registerCustomer(customerRegistrationRequest);
  }
}
