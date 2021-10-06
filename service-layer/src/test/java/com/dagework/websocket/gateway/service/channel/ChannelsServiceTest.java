package com.dagework.websocket.gateway.service.channel;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

class ChannelsServiceTest {
    @Mock
    private CodeGenerator codeGenerator;

    private ChannelsService channelsService;

    private AutoCloseable closeable;

    @BeforeMethod
    public void setUp() {
        this.closeable = MockitoAnnotations.openMocks(this);
        this.channelsService = new ChannelsService(codeGenerator);
    }

    @AfterMethod
    public void tearDown() throws Exception {
        closeable.close();
    }

    @Test
    public void testCreateChannel() {
        String expected = "code";
        when(codeGenerator.generate()).thenReturn(expected);

        Channel channel = channelsService.create();

        Assert.assertEquals(expected, channel.getId());
    }
}
