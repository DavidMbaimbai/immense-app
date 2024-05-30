package com.davymbaimbai.notificationservice.kafka;

import com.davymbaimbai.notificationservice.entity.Notification;
import com.davymbaimbai.notificationservice.enums.NotificationType;
import com.davymbaimbai.notificationservice.kafka.order.OrderConfirmation;
import com.davymbaimbai.notificationservice.kafka.payment.PaymentConfirmation;
import com.davymbaimbai.notificationservice.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationConsumer {
    private final NotificationRepository repository;

    //private final EmailService emailService;
    @KafkaListener(topics = "payment-topic")
    public void consumePaymentSuccessNotification(PaymentConfirmation paymentConfirmation) {
        log.info(String.format("Consuming the message from payment-top Topic:: %S", paymentConfirmation));
        repository.save(Notification.builder()
                .type(NotificationType.PAYMENT_CONFIRMATION)
                .notificationDate(LocalDateTime.now())
                .paymentConfirmation(paymentConfirmation)
                .build());
        // todo send email

    }

    @KafkaListener(topics = "order-topic")
    public void consumeOrderConfirmationNotification(OrderConfirmation orderConfirmation) {
        log.info(String.format("Consuming the message from order-topic Topic:: %S", orderConfirmation));
        repository.save(Notification.builder()
                .type(NotificationType.PAYMENT_CONFIRMATION)
                .notificationDate(LocalDateTime.now())
                .orderConfirmation(orderConfirmation)
                .build());
        // todo send email

    }
}
