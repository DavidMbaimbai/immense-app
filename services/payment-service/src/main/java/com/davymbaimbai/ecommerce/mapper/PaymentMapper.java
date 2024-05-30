package com.davymbaimbai.ecommerce.mapper;

import com.davymbaimbai.ecommerce.entity.Payment;
import com.davymbaimbai.ecommerce.record.PaymentRequest;
import org.springframework.stereotype.Service;

@Service
public class PaymentMapper {
    public Payment toPayment(PaymentRequest request) {
        return Payment.builder()
                .id(request.id())
                .amount(request.amount())
                .paymentMethod(request.paymentMethod())
                .orderId(request.orderId())
                .build();
    }
}
