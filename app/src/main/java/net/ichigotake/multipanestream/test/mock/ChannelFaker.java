package net.ichigotake.multipanestream.test.mock;

import net.ichigotake.multipanestream.sdk.Channel;
import net.ichigotake.multipanestream.sdk.ChannelBuilder;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class ChannelFaker {

    public Channel create() {
        CharSequence name = createName();
        return new ChannelBuilder()
                .setName(name)
                .setTopic(name  + " について語るチャンネル")
                .build();
    }

    private CharSequence createName() {
        List<CharSequence> names = Arrays.<CharSequence>asList(
                "#beach",
                "#cafe",
                "#sushi",
                "#myhome",
                "#library",
                "#lounge",
                "#office"
        );
        Collections.shuffle(names);
        return names.get(0);
    }

}
