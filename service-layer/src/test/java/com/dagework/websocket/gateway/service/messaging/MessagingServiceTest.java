package com.dagework.websocket.gateway.service.messaging;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

class MessagingServiceTest {
    private MessagingService messagingService;

    @BeforeMethod
    public void setUp() {
        this.messagingService = new MessagingService();
    }

    @Test
    public void testCreate() {
        Message message = new Message("from", "content", null);

        Message actual = messagingService.create(message);

        Assert.assertEquals("from", actual.getFrom());
        Assert.assertEquals("content", actual.getContent());
        Assert.assertNotNull( actual.getTime());
    }
}
