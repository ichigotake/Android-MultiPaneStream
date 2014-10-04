package net.ichigotake.multipanestream.attribute.channel;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import net.ichigotake.multipanestream.R;
import net.ichigotake.multipanestream.sdk.Channel;

import java.util.ArrayList;
import java.util.List;

public final class ChannelFragment extends ListFragment {

    private final List<Channel> channelList = new ArrayList<Channel>();
    private ChannelAdapter adapter;
    private OnChannelSelectedListener onChannelSelectedListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (!(activity instanceof OnChannelSelectedListener)) {
            throw new IllegalStateException(
                    "Must implements OnChannelSelectedListener to " + activity.getClass().getSimpleName());
        }
        this.onChannelSelectedListener = (OnChannelSelectedListener)activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_channel, parent, false);
        this.adapter = new ChannelAdapter(getActivity(), channelList);
        setListAdapter(adapter);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Channel channel = (Channel) parent.getItemAtPosition(position);
                onChannelSelectedListener.onChannelSelected(channel);
                view.setSelected(true);
            }
        });
    }

    @Override
    public void onDetach() {
        this.onChannelSelectedListener = null;
        super.onDetach();
    }

    public void addChannel(Channel channel) {
        if (!this.channelList.contains(channel)) {
            this.channelList.add(channel);
        }
        this.adapter.notifyDataSetChanged();
    }

}
