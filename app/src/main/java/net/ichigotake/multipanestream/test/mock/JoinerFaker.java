package net.ichigotake.multipanestream.test.mock;

import net.ichigotake.multipanestream.sdk.Joiner;
import net.ichigotake.multipanestream.sdk.JoinerBuilder;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class JoinerFaker {

    public Joiner create() {
        List<CharSequence> names = Arrays.<CharSequence>asList(
                "katagiri",
                "miyamoto",
                "tachibana",
                "suzuki",
                "fukuyama",
                "chie",
                "takehito"
        );
        Collections.shuffle(names);
        return new JoinerBuilder().setName(names.get(0)).build();
    }

}
