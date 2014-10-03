package net.ichigotake.multipanestream.stream;

import net.ichigotake.multipanestream.sdk.Message;

import java.util.List;

public interface StreamContainer {

    void clearMessage();

    void addMessage(Message message);

    void addMessageAll(List<Message> message);

}
