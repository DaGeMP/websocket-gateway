package com.dagework.websocket.gateway.web;

import com.dagework.websocket.gateway.service.messaging.Message;
import com.dagework.websocket.gateway.service.messaging.MessagingService;
import com.github.dozermapper.core.Mapper;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebsocketController {
    private final Mapper mapper;
    private final MessagingService messagingService;

    public WebsocketController(Mapper mapper,
                               MessagingService messagingService) {
        this.mapper = mapper;
        this.messagingService = messagingService;
    }

    @MessageMapping("/channel/{id}")
    @SendTo("/topic/channel/{id}")
    public MessageDTO send(@DestinationVariable String id,
                           MessageDTO messageDTO) {
        Message dtoMapped = mapper.map(messageDTO, Message.class);
        Message message = messagingService.create(dtoMapped);
        return mapper.map(message, MessageDTO.class);
    }
}
