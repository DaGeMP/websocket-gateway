package com.dagework.websocket.gateway.service.channel;

import java.util.UUID;

public class SimpleUUIDCodeGenerator implements CodeGenerator {
    private static final int MAX_LENGTH = 5;
    private final int length;

    public SimpleUUIDCodeGenerator(int length) {
        if (length < 1 || length > MAX_LENGTH) {
            throw new InvalidLengthException();
        }
        this.length = length;
    }

    public String generate() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().substring(0, length);
    }
}
