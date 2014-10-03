package net.ichigotake.multipanestream.app.tablet;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.text.TextUtils;

import net.ichigotake.multipanestream.R;
import net.ichigotake.multipanestream.attribute.channel.ChannelFragment;
import net.ichigotake.multipanestream.attribute.joiner.JoinerFragment;
import net.ichigotake.multipanestream.sdk.Channel;
import net.ichigotake.multipanestream.sdk.Message;
import net.ichigotake.multipanestream.stream.LogStreamFragment;
import net.ichigotake.multipanestream.stream.MainStreamFragment;
import net.ichigotake.multipanestream.test.mock.ChannelFaker;
import net.ichigotake.multipanestream.test.mock.MessageFaker;

public final class TabletMultiPaneStreamActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablet_multi_pane_stream);

        MessageFaker messageFaker = new MessageFaker();
        Channel currentChannel = new ChannelFaker().create();
        FragmentManager fragmentManager = getFragmentManager();
        MainStreamFragment mainStreamFragment = (MainStreamFragment) fragmentManager
                .findFragmentById(R.id.activity_tablet_multi_pane_stream_main_stream);
        mainStreamFragment.setChannel(currentChannel);
        LogStreamFragment logStreamFragment = (LogStreamFragment) fragmentManager
                .findFragmentById(R.id.activity_tablet_multi_pane_stream_log_stream);
        ChannelFragment channelFragment = (ChannelFragment) fragmentManager
                .findFragmentById(R.id.activity_tablet_multi_pane_stream_attribute_channel);
        JoinerFragment joinerFragment = (JoinerFragment) fragmentManager
                .findFragmentById(R.id.activity_tablet_multi_pane_stream_attribute_joiner);
        for (int i=0; i<100; i++) {
            Message message = messageFaker.create();
            logStreamFragment.addMessage(message);
            channelFragment.addChannel(message.getChannel());
            if (TextUtils.equals(currentChannel.getName(), message.getChannel().getName())) {
                mainStreamFragment.addMessage(message);
                joinerFragment.addJoiner(message.getAuthor());
            }
        }

    }

}
