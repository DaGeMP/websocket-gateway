package com.dagework.websocket.gateway.service.messaging;

public class Message {
    private final String from;
    private final String content;
    private final String time;

    public Message(String from, String content, String time) {
        this.from = from;
        this.content = content;
        this.time = time;
    }

    public String getFrom() {
        return from;
    }

    public String getContent() {
        return content;
    }

    public String getTime() {
        return time;
    }
}
