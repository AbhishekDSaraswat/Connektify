package com.sitrc.connektify.notification_service.service;

public interface SendNotification {

    void send(Long userId, String message);
}
