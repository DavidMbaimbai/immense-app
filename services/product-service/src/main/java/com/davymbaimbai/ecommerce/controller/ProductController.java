package com.davymbaimbai.ecommerce.controller;

import com.davymbaimbai.ecommerce.record.ProductPurchaseRequest;
import com.davymbaimbai.ecommerce.record.ProductRequest;
import com.davymbaimbai.ecommerce.record.ProductResponse;
import com.davymbaimbai.ecommerce.record.ProductPurchaseResponse;
import com.davymbaimbai.ecommerce.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @PostMapping("/create")
    public ResponseEntity<Integer> createProduct(
            @RequestBody @Valid ProductRequest request
    ) {
        return ResponseEntity.ok(service.createProduct(request));
    }

    @PostMapping("/purchase")
    public ResponseEntity<List<ProductPurchaseResponse>> purchaseProducts(
            @RequestBody List<ProductPurchaseRequest> request
    ) {
        return ResponseEntity.ok(service.purchaseProducts(request));
    }

    @GetMapping("/{product_id}")
    public ResponseEntity<ProductResponse> findProductById(
            @PathVariable("product_id") Integer productId
    ) {
        return ResponseEntity.ok(service.findProductById(productId));
    }
    @GetMapping("/all")
    public ResponseEntity<List<ProductResponse>> findAllProducts(
    ) {
        return ResponseEntity.ok(service.findAllProducts());
    }
}
