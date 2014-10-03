package net.ichigotake.multipanestream.attribute.channel;

import android.content.Context;
import android.widget.ArrayAdapter;

import net.ichigotake.multipanestream.sdk.Channel;

import java.util.List;

public class ChannelAdapter extends ArrayAdapter<Channel> {

    public ChannelAdapter(Context context, List<Channel> channelList) {
        super(context, android.R.layout.simple_list_item_1, channelList);
    }
}
