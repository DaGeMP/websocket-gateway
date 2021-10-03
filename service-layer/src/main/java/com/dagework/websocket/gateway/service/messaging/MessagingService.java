package com.dagework.websocket.gateway.service.messaging;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MessagingService {
    public Message create(Message message) {
        String time = new SimpleDateFormat("HH:mm").format(new Date());
        return new Message(message.getFrom(), message.getContent(), time);
    }
}
