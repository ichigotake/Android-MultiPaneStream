package net.ichigotake.multipanestream.sdk;

public final class MessageBuilder {

    long timestamp;
    CharSequence title;
    CharSequence message;
    Channel channel;
    Joiner author;

    public Message build() {
        return new MessageImpl(this);
    }

    public MessageBuilder setTimestamp(long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public MessageBuilder setTitle(CharSequence title) {
        this.title = title;
        return this;
    }

    public MessageBuilder setMessage(CharSequence message) {
        this.message = message;
        return this;
    }

    public MessageBuilder setChannel(Channel channel) {
        this.channel = channel;
        return this;
    }

    public MessageBuilder setAuthor(Joiner author) {
        this.author = author;
        return this;
    }

}
