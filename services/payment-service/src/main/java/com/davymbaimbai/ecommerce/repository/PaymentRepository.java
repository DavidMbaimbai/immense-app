package com.davymbaimbai.ecommerce.repository;

import com.davymbaimbai.ecommerce.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {
}
