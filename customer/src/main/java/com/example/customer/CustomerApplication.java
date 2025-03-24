package com.example.customer;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class CustomerApplication {
  public static void main(String[] args) {
    SpringApplication.run(CustomerApplication.class, args);
  }
  
  @Bean
  public ApplicationRunner initializer(CustomerRepository customerRepository) {
    return args -> {
      // Check if the repository is empty to avoid duplicates on restart
      if (customerRepository.count() == 0) {
        // Create sample customers
        customerRepository.save(new Customer("John", "Doe", "john.doe@example.com"));
        customerRepository.save(new Customer("Jane", "Smith", "jane.smith@example.com"));
        customerRepository.save(new Customer("Robert", "Johnson", "robert.johnson@example.com"));
        customerRepository.save(new Customer("Emily", "Davis", "emily.davis@example.com"));
        
        System.out.println("Sample customers created successfully!");
      } else {
        System.out.println("Customer database already contains data, skipping initialization.");
      }
    };
  }
}
