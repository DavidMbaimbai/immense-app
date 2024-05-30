package com.davymbaimbai.notificationservice.repository;

import com.davymbaimbai.notificationservice.entity.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificationRepository extends MongoRepository<Notification, Integer> {
}
