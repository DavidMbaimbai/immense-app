package com.davymbaimbai.notificationservice.entity;

import com.davymbaimbai.notificationservice.enums.NotificationType;
import com.davymbaimbai.notificationservice.kafka.order.OrderConfirmation;
import com.davymbaimbai.notificationservice.kafka.payment.PaymentConfirmation;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@Document
public class Notification {
    @Id
    private String id;
    private NotificationType type;
    private LocalDateTime notificationDate;
    private OrderConfirmation orderConfirmation;
    private PaymentConfirmation paymentConfirmation;
}
