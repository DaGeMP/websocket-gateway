package com.dagework.websocket.gateway.web;

import com.dagework.websocket.gateway.service.messaging.Message;
import com.dagework.websocket.gateway.service.messaging.MessagingService;
import com.github.dozermapper.core.Mapper;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

class WebsocketControllerTest {
    @Mock
    private MessagingService messagingService;
    @Mock
    private Mapper mapper;
    private AutoCloseable closeable;

    private WebsocketController websocketController;

    @BeforeMethod
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
        this.websocketController = new WebsocketController(mapper, messagingService);
    }

    @AfterMethod
    void tearDown() throws Exception {
        closeable.close();
    }

    @Test
    public void testSend() {
        MessageDTO messageDTO = new MessageDTO("", "", null);
        Message message = new Message("", "", null);
        MessageDTO expected = new MessageDTO("", "", null);
        when(mapper.map(messageDTO, Message.class)).thenReturn(message);
        when(mapper.map(message, MessageDTO.class)).thenReturn(expected);
        when(messagingService.create(message)).thenReturn(message);

        MessageDTO actual = websocketController.send("", messageDTO);

        Assert.assertEquals(expected, actual);
    }
}
