package net.ichigotake.multipanestream.attribute.channel;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.ichigotake.multipanestream.R;
import net.ichigotake.multipanestream.sdk.Channel;

import java.util.ArrayList;
import java.util.List;

public final class ChannelFragment extends ListFragment {

    private final List<Channel> channelList = new ArrayList<Channel>();
    private ChannelAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_channel, parent, false);
        this.adapter = new ChannelAdapter(getActivity(), channelList);
        setListAdapter(adapter);
        return view;
    }

    public void addChannel(Channel channel) {
        if (!this.channelList.contains(channel)) {
            this.channelList.add(channel);
        }
        this.adapter.notifyDataSetChanged();
    }

}
