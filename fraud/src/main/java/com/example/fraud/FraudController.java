package com.example.fraud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/fraud-check")
public class FraudController {
  private final Logger log = LoggerFactory.getLogger(FraudController.class);
  private final FraudCheckService fraudCheckService;

  public FraudController(FraudCheckService fraudCheckService) {
    this.fraudCheckService = fraudCheckService;
  }

  @GetMapping(path = "{customerId}")
  public FraudCheckResponse isFraudulentCustomer(@PathVariable("customerId") Integer customerId) {
    log.info("Fraud Checking customer: {}", customerId);
    return new FraudCheckResponse(fraudCheckService.isFraudulentCustomer(customerId));
  }
}
