package com.dagework.websocket.gateway.web;

import com.dagework.websocket.gateway.service.messaging.Message;
import com.dagework.websocket.gateway.service.messaging.MessagingService;
import com.github.dozermapper.core.Mapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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

    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
        this.websocketController = new WebsocketController(mapper, messagingService);
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
    }

    @Test
    void testSend() {
        MessageDTO messageDTO = new MessageDTO("", "", null);
        Message message = new Message("", "", null);
        MessageDTO expected = new MessageDTO("", "", null);
        when(mapper.map(messageDTO, Message.class)).thenReturn(message);
        when(mapper.map(message, MessageDTO.class)).thenReturn(expected);
        when(messagingService.create(message)).thenReturn(message);

        MessageDTO actual = websocketController.send("", messageDTO);

        Assertions.assertEquals(expected, actual);
    }
}
