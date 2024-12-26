package com.sitrc.connektify.notification_service.consumer;

import com.sitrc.connektify.connections_service.event.AcceptConnectionRequestEvent;
import com.sitrc.connektify.connections_service.event.SendConnectionRequestEvent;
import com.sitrc.connektify.notification_service.service.SendNotification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ConnectionServiceConsumer {

    private final SendNotification sendNotification;

    @KafkaListener(topics = "send-connection-request-topic")
    public void handleSendConnectionRequest(SendConnectionRequestEvent sendConnectionRequestEvent) {
        log.info("handle connections: handleSendConnectionRequest: {}", sendConnectionRequestEvent);
     String message =
             "you have receive a connection request from user with id: %d"+sendConnectionRequestEvent.getSenderId();
       sendNotification.send(sendConnectionRequestEvent.getReceiverId(), message);

    }
    @KafkaListener(topics = "accept-connection-request-topic")
    public void handleAcceptConnectionRequest(AcceptConnectionRequestEvent acceptConnectionRequestEvent){
        log.info("handle connections: handleAcceptConnectionRequest: {}", acceptConnectionRequestEvent);

        String message =
                "your Connection request has been accepted by yhe user with id: %d"+acceptConnectionRequestEvent.getReceiverId();
        sendNotification.send(acceptConnectionRequestEvent.getSenderId(), message);

    }

}
