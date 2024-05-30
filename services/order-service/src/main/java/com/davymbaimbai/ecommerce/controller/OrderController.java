package com.davymbaimbai.ecommerce.controller;

import com.davymbaimbai.ecommerce.record.OrderRequest;
import com.davymbaimbai.ecommerce.record.OrderResponse;
import com.davymbaimbai.ecommerce.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService service;

    @PostMapping("/create")
    public ResponseEntity<Integer> createOrder(
            @RequestBody @Valid OrderRequest request
    ) {
        return ResponseEntity.ok(service.createOrder(request));
    }
    @GetMapping("/all")
    public ResponseEntity<List<OrderResponse>> findAllOrders(){
        return ResponseEntity.ok(service.findAllOrders());

    }
    @GetMapping("/{order-id}")
    public  ResponseEntity<OrderResponse> findOrderById(
            @PathVariable("order-id") Integer orderId
    ){
        return ResponseEntity.ok(service.findOrderById(orderId));
    }
}
