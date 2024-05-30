package com.davymbaimbai.ecommerce.service;

import com.davymbaimbai.ecommerce.mapper.PaymentMapper;
import com.davymbaimbai.ecommerce.notification.NotificationProducer;
import com.davymbaimbai.ecommerce.record.PaymentNotificationRequest;
import com.davymbaimbai.ecommerce.record.PaymentRequest;
import com.davymbaimbai.ecommerce.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository repository;
    private final PaymentMapper mapper;
    private final NotificationProducer notificationProducer;
    public Integer createPayment(PaymentRequest request) {
        var payment = repository.save(mapper.toPayment(request));
        notificationProducer.sendNotification(
                new PaymentNotificationRequest(
                        request.orderReference(),
                        request.amount(),
                        request.paymentMethod(),
                        request.customer().firstName(),
                        request.customer().lastName(),
                        request.customer().email()
                )
        );
        return payment.getId();
    }
}
