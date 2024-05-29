package com.davymbaimbai.ecommerce.repository;

import com.davymbaimbai.ecommerce.entity.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepository extends JpaRepository<OrderLine, Integer> {
}
