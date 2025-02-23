package com.example.customer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Customer {
  @Id
  @SequenceGenerator(name = "customer_id_sequence", sequenceName = "customer_id_sequence")
  @GeneratedValue(generator = "customer_id_sequence", strategy = GenerationType.SEQUENCE)
  private Long id;
  private String firstName;
  private String lastName;
  private String email;

  public Customer() {  }

  public Customer(String firstName, String lastName, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

  public static Customer of(String firstName, String lastName, String email) {
    return new Customer(firstName, lastName, email);
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getEmail() {
    return email;
  }
}
