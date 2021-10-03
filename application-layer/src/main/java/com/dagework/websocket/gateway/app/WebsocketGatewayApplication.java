package com.dagework.websocket.gateway.app;

import com.dagework.websocket.gateway.service.channel.ChannelsService;
import com.dagework.websocket.gateway.service.channel.CodeGenerator;
import com.dagework.websocket.gateway.service.channel.SimpleUUIDCodeGenerator;
import com.dagework.websocket.gateway.service.messaging.MessagingService;
import com.dagework.websocket.gateway.web.ChannelsWebController;
import com.dagework.websocket.gateway.web.WebsocketController;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WebsocketGatewayApplication {
    private static final int CODE_LENGTH = 5;

    public static void main(String[] args) {
        SpringApplication.run(WebsocketGatewayApplication.class, args);
    }

    @Bean
    public ChannelsWebController getChannelsWebController() {
        Mapper mapper = DozerBeanMapperBuilder.buildDefault();
        CodeGenerator codeGenerator = new SimpleUUIDCodeGenerator(CODE_LENGTH);
        ChannelsService channelsService = new ChannelsService(codeGenerator);
        return new ChannelsWebController(mapper, channelsService);
    }

    @Bean
    public WebsocketController getWebsocketController() {
        Mapper mapper = DozerBeanMapperBuilder.buildDefault();
        MessagingService messagingService = new MessagingService();
        return new WebsocketController(mapper, messagingService);
    }
}
