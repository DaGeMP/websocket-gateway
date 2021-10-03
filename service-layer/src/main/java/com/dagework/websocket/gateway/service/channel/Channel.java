package com.dagework.websocket.gateway.service.channel;

import java.util.Objects;

public final class Channel {
    private final String id;

    public Channel(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Channel that = (Channel) obj;
        return Objects.equals(this.id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Channel["
            + "id=" + id + ']';
    }

    public String getId() {
        return id;
    }
}
