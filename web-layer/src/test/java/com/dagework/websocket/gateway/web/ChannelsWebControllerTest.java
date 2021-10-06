package com.dagework.websocket.gateway.web;

import com.dagework.websocket.gateway.service.channel.Channel;
import com.dagework.websocket.gateway.service.channel.ChannelsService;
import com.github.dozermapper.core.Mapper;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
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

    @BeforeMethod
    public void setUp() {
        this.closeable = MockitoAnnotations.openMocks(this);
        this.channelsWebController = new ChannelsWebController(mapper, channelsService);
    }

    @AfterMethod
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

        Assert.assertEquals(expected, channelDTO);
    }
}
