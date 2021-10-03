package com.dagework.websocket.gateway.web;

public class MessageDTO {
    private final String from;
    private final String content;
    private final String time;

    public MessageDTO(String from, String content, String time) {
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
