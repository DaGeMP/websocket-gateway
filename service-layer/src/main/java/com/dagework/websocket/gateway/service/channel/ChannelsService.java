package com.dagework.websocket.gateway.service.channel;

public class ChannelsService {
    private final CodeGenerator codeGenerator;

    public ChannelsService(CodeGenerator codeGenerator) {
        this.codeGenerator = codeGenerator;
    }

    public Channel create() {
        return new Channel(codeGenerator.generate());
    }
}
