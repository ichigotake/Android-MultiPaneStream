package net.ichigotake.multipanestream.sdk;

public final class ChannelBuilder {

    CharSequence name;
    CharSequence topic;

    public Channel build() {
        return new ChannelImpl(this);
    }

    public ChannelBuilder setTopic(CharSequence topic) {
        this.topic = topic;
        return this;
    }

    public ChannelBuilder setName(CharSequence name) {
        this.name = name;
        return this;
    }

}
