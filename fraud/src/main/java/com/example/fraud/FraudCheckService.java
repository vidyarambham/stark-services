package com.example.fraud;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FraudCheckService {
  private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

  public FraudCheckService(FraudCheckHistoryRepository fraudCheckHistoryRepository) {
    this.fraudCheckHistoryRepository = fraudCheckHistoryRepository;
  }

  public boolean isFraudulentCustomer(Integer customerId) {
    fraudCheckHistoryRepository.save(FraudCheckHistory.of(customerId, false, LocalDateTime.now()));
    return false;
  }
}
