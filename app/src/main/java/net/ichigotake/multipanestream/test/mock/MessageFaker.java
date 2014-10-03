package net.ichigotake.multipanestream.test.mock;

import net.ichigotake.multipanestream.sdk.Joiner;
import net.ichigotake.multipanestream.sdk.Message;
import net.ichigotake.multipanestream.sdk.MessageBuilder;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public final class MessageFaker {

    private final JoinerFaker joinerFaker = new JoinerFaker();
    private long baseTimestamp = Calendar.getInstance().getTimeInMillis();

    public Message create() {
        Joiner author = joinerFaker.create();
        return new MessageBuilder()
                .setChannel(new ChannelFaker().create())
                .setTimestamp(baseTimestamp++)
                .setTitle(author.getName())
                .setMessage(createMessage())
                .setAuthor(author)
                .build();
    }

    private CharSequence createMessage() {
        List<CharSequence> names = Arrays.<CharSequence>asList(
                "誰もケッコンしてない初々しさ ",
                "にぎやかで楽しそうだから討論ライブとかあったら見てみたいな",
                "世界観の共有のためにLintの説明からしないといけないかもしれないし、たいへんそう",
                "名前を忘れてしまった…",
                "OSSのデザイン手伝いますプロジェクトとかありませんでしたっけ",
                "19:37 に復帰を確認",
                "ｳーﾑ",
                "アップデートの配信は11月1日からとかなんとか。",
                "もう3時だ",
                "まだですよ",
                "おなじく",
                "あらおやすい",
                "参考にします (=v=*)",
                "なるほど辞書作戦か…",
                "罠の一環…?",
                "若さで乗り切ろう！！"
        );
        Collections.shuffle(names);
        return names.get(0);
    }

}
