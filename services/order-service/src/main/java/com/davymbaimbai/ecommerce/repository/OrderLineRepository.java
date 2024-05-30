package com.davymbaimbai.ecommerce.repository;

import com.davymbaimbai.ecommerce.entity.OrderLine;
import com.davymbaimbai.ecommerce.record.OrderLineResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderLineRepository extends JpaRepository<OrderLine, Integer> {
    List<OrderLine> findAllByOrderId(Integer orderId);
}
