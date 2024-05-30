package com.davymbaimbai.notificationservice.kafka.order;

import com.davymbaimbai.notificationservice.enums.PaymentMethod;
import com.davymbaimbai.notificationservice.record.Customer;
import com.davymbaimbai.notificationservice.record.Product;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        Customer customer,
        List<Product> products
) {
}
