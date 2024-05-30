package com.davymbaimbai.ecommerce.service;

import com.davymbaimbai.ecommerce.mapper.OrderLineMapper;
import com.davymbaimbai.ecommerce.record.OrderLineRequest;
import com.davymbaimbai.ecommerce.record.OrderLineResponse;
import com.davymbaimbai.ecommerce.repository.OrderLineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderLineService {
    private final OrderLineRepository repository;
    private final OrderLineMapper mapper;
    public Integer saveOrderLine(OrderLineRequest request) {
     var orderLine = mapper.toOrderLine(request);
     return repository.save(orderLine).getId();
    }

    public List<OrderLineResponse> findByOrderId(Integer orderId) {
        return repository.findAllByOrderId(orderId)
                .stream()
                .map(mapper::toOrderLineResponse)
                .collect(Collectors.toList());

    }
}
