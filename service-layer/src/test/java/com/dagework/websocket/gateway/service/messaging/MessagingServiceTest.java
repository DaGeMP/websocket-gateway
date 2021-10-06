package com.dagework.websocket.gateway.service.messaging;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MessagingServiceTest {
    private MessagingService messagingService;

    @BeforeEach
    public void setUp() {
        this.messagingService = new MessagingService();
    }

    @Test
    void testCreate() {
        Message message = new Message("from", "content", null);

        Message actual = messagingService.create(message);

        Assertions.assertEquals("bananas", actual.getFrom());
        Assertions.assertEquals("content", actual.getContent());
        Assertions.assertNotNull( actual.getTime());
    }
}
