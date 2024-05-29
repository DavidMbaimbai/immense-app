package com.davymbaimbai.ecommerce.controller;

import com.davymbaimbai.ecommerce.record.OrderRequest;
import com.davymbaimbai.ecommerce.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService service;

    public ResponseEntity<Integer> createOrder(
            @RequestBody @Valid OrderRequest request
    ){
return ResponseEntity.ok(service.createOrder(request));
    }
}
