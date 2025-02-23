package com.example.fraud;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

import java.time.LocalDateTime;

@Entity
public class FraudCheckHistory {
  @Id
  @SequenceGenerator(name = "fraud_id_sequence", sequenceName = "fraud_id_sequence")
  @GeneratedValue(generator = "fraud_id_sequence", strategy = GenerationType.SEQUENCE)
  private Long id;
  private Integer customerId;
  private boolean isFraudster;
  private LocalDateTime createdAt;

  public FraudCheckHistory() {  }

  public FraudCheckHistory(Integer customerId, boolean isFraudster, LocalDateTime createdAt) {
    this.customerId = customerId;
    this.isFraudster = isFraudster;
    this.createdAt = createdAt;
  }

  public static FraudCheckHistory of(Integer customerId, boolean isFraudster, LocalDateTime createdAt) {
    return new FraudCheckHistory(customerId, isFraudster, createdAt);
  }

  public Integer getCustomerId() {
    return customerId;
  }

  public boolean isFraudster() {
    return isFraudster;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }
}
