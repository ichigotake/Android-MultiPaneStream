package net.ichigotake.multipanestream.sdk;

import android.support.v4.util.ArrayMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class ChannelJoiners {

    private final Map<String, List<Joiner>> joinersMap = new ArrayMap<String, List<Joiner>>();

    public void add(Channel channel, Joiner joiner) {
        List<Joiner> joiners = joinersMap.get(channel.getName().toString());
        if (joiners == null) {
            joiners = new CopyOnWriteArrayList<Joiner>();
        }
        if (!joiners.contains(joiner)) {
            joiners.add(joiner);
        }
        joinersMap.put(channel.getName().toString(), joiners);
    }

    public List<Joiner> get(Channel channel) {
        List<Joiner> joiners = joinersMap.get(channel.getName().toString());
        if (joiners == null) {
            joiners = new ArrayList<Joiner>();
        }
        return joiners;
    }
}
