package net.ichigotake.multipanestream.test.mock;

import net.ichigotake.multipanestream.sdk.ChannelCategory;
import net.ichigotake.multipanestream.sdk.ChannelCategoryBuilder;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class ChannelCategoryFaker {

    public ChannelCategory create() {
        return new ChannelCategoryBuilder()
                .setName(createName())
                .build();
    }

    private CharSequence createName() {
        List<CharSequence> names = Arrays.<CharSequence>asList(
                "irc.friend-chat.jp",
                "irc.freenode.net",
                "chat.chatwork",
                "chat.gitter",
                "chat.hipchat",
                "chat.slack"
        );
        Collections.shuffle(names);
        return names.get(0);
    }

}
