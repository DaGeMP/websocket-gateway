package com.dagework.websocket.gateway.web;

import com.dagework.websocket.gateway.service.channel.ChannelsService;
import com.github.dozermapper.core.Mapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin()
@RestController
public class ChannelsWebController {
    private final Mapper mapper;
    private final ChannelsService channelsService;

    public ChannelsWebController(Mapper mapper,
                                 ChannelsService channelsService) {
        this.mapper = mapper;
        this.channelsService = channelsService;
    }

    @GetMapping("/channels")
    public ChannelDTO getChannel() {
        return mapper.map(channelsService.create(), ChannelDTO.class);
    }
}
