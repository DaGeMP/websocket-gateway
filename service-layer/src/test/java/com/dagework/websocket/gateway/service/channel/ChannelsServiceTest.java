package com.dagework.websocket.gateway.service.channel;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

class ChannelsServiceTest {
    @Mock
    private CodeGenerator codeGenerator;

    private ChannelsService channelsService;

    private AutoCloseable closeable;

    @BeforeEach
    public void setUp() {
        this.closeable = MockitoAnnotations.openMocks(this);
        this.channelsService = new ChannelsService(codeGenerator);
    }

    @AfterEach
    public void tearDown() throws Exception {
        closeable.close();
    }

    @Test
    public void testCreateChannel() {
        String expected = "code";
        when(codeGenerator.generate()).thenReturn(expected);

        Channel channel = channelsService.create();

        Assertions.assertEquals(expected, channel.getId());
    }
}
