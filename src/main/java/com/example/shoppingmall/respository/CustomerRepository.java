package com.example.shoppingmall.respository;

import com.example.shoppingmall.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
