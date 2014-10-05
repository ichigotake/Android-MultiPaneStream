package net.ichigotake.multipanestream.sdk;

import android.support.v4.util.ArrayMap;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

public class ChannelTree {

    private final ArrayMap<ChannelCategory, List<Channel>> tree;

    public ChannelTree() {
        this.tree = new ArrayMap<ChannelCategory, List<Channel>>();
    }

    public void addChannel(ChannelCategory category, Channel channel) {
        List<Channel> channelList = getChannelList(category);
        if (!channelList.contains(channel)) {
            channelList.add(channel);
            this.tree.put(category, channelList);
        }
    }

    public List<Channel> getChannelList(ChannelCategory category) {
        List<Channel> channelList = this.tree.get(category);
        if (channelList == null) {
            channelList = new ArrayList<Channel>();
        }
        return channelList;
    }

    public ChannelCategory findCategory(String name) {
        ChannelCategory found = null;
        for (ChannelCategory item : tree.keySet()) {
            if (TextUtils.equals(name, item.getName())) {
                found = item;
            }
        }
        return found;
    }

    public boolean containsChannelCategory(ChannelCategory category) {
        return this.tree.get(category) != null;
    }
}
