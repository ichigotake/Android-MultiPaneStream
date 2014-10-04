package net.ichigotake.multipanestream.attribute.joiner;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.ichigotake.multipanestream.R;
import net.ichigotake.multipanestream.sdk.Channel;
import net.ichigotake.multipanestream.sdk.ChannelJoiners;
import net.ichigotake.multipanestream.sdk.Joiner;

public final class JoinerFragment extends ListFragment {

    private final ChannelJoiners channelJoiners = new ChannelJoiners();
    private JoinerAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_joiner, parent, false);
        this.adapter = new JoinerAdapter(getActivity());
        setListAdapter(adapter);
        return view;
    }

    public void addJoiner(Channel channel, Joiner author) {
        channelJoiners.add(channel, author);
    }

    public void setChannel(Channel channel) {
        adapter.clear();
        adapter.addAll(channelJoiners.get(channel));
    }

}
