package com.davymbaimbai.ecommerce.repository;

import com.davymbaimbai.ecommerce.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
