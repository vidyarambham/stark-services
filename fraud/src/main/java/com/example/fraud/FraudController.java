package com.example.fraud;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/v1/fraud-check")
public class FraudController {
  private final FraudCheckService fraudCheckService;

  public FraudController(FraudCheckService fraudCheckService) {
    this.fraudCheckService = fraudCheckService;
  }

  @GetMapping(path = "{customerId}")
  public FraudCheckResponse isFraudulentCustomer(@PathVariable("customerId") Integer customerId) {
    return new FraudCheckResponse(fraudCheckService.isFraudulentCustomer(customerId));
  }
}
