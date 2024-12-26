package com.sitrc.connektify.notification_service.service.impl;

import com.sitrc.connektify.notification_service.entity.Notification;
import com.sitrc.connektify.notification_service.repository.NotificationRepository;
import com.sitrc.connektify.notification_service.service.SendNotification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SendNotificationImpl implements SendNotification {

    private final NotificationRepository notificationRepository;


    @Override
    public void send(Long userId, String message) {

        Notification notification = new Notification();
        notification.setMessage(message);
        notification.setUserId(userId);

        notificationRepository.save(notification);
        log.info("Notification saved for user: {}", userId);
    }


}
