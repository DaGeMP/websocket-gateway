package com.dagework.websocket.gateway.web;

import com.dagework.websocket.gateway.service.channel.Channel;
import com.dagework.websocket.gateway.service.channel.ChannelsService;
import com.github.dozermapper.core.Mapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

class ChannelsWebControllerTest {
    @Mock
    private Mapper mapper;
    @Mock
    private ChannelsService channelsService;
    private AutoCloseable closeable;
    private ChannelsWebController channelsWebController;

    @BeforeEach
    public void setUp() {
        this.closeable = MockitoAnnotations.openMocks(this);
        this.channelsWebController = new ChannelsWebController(mapper, channelsService);
    }

    @AfterEach
    public void tearDown() throws Exception {
        closeable.close();
    }

    @Test
    public void testGetChannel() {
        Channel channelToMap = new Channel("");
        ChannelDTO expected = new ChannelDTO();
        when(channelsService.create()).thenReturn(channelToMap);
        when(mapper.map(channelToMap, ChannelDTO.class)).thenReturn(expected);

        ChannelDTO channelDTO = channelsWebController.getChannel();

        Assertions.assertEquals(expected, channelDTO);
    }
}
