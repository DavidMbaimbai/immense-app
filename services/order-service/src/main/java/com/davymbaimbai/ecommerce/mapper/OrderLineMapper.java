package com.davymbaimbai.ecommerce.mapper;

import com.davymbaimbai.ecommerce.entity.Order;
import com.davymbaimbai.ecommerce.entity.OrderLine;
import com.davymbaimbai.ecommerce.record.OrderLineRequest;
import com.davymbaimbai.ecommerce.record.OrderLineResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderLineMapper {
    public OrderLine toOrderLine(OrderLineRequest request) {
        return OrderLine.builder()
                .id(request.id())
                .order(Order.builder()
                        .id(request.orderId())
                        .build())
                .productId(request.productId())
                .quantity(request.quantity())
                .build();
    }

    public OrderLineResponse toOrderLineResponse(OrderLine orderLine) {
        return new OrderLineResponse(
                orderLine.getId(),
                orderLine.getQuantity());
    }
}
