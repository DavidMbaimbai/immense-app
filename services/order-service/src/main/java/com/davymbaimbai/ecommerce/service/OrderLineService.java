package com.davymbaimbai.ecommerce.service;

import com.davymbaimbai.ecommerce.mapper.OrderLineMapper;
import com.davymbaimbai.ecommerce.record.OrderLineRequest;
import com.davymbaimbai.ecommerce.repository.OrderLineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderLineService {
    private final OrderLineRepository repository;
    private final OrderLineMapper mapper;
    public Integer saveOrderLine(OrderLineRequest request) {
     var orderLine = mapper.toOrderLine(request);
     return repository.save(orderLine).getId();
    }
}
