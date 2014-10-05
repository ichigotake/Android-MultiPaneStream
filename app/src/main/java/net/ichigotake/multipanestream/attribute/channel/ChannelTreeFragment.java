package net.ichigotake.multipanestream.attribute.channel;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import net.ichigotake.multipanestream.R;
import net.ichigotake.multipanestream.sdk.Channel;
import net.ichigotake.multipanestream.sdk.ChannelCategory;

public final class ChannelTreeFragment extends Fragment {

    private final ChannelTreeExpandableListCollection channelTreeExpandableListCollection =
            new ChannelTreeExpandableListCollection();
    private ExpandableListView listView;
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
        this.adapter = new ChannelAdapter(getActivity(), channelTreeExpandableListCollection);
        this.listView = (ExpandableListView) view.findViewById(R.id.fragment_channel_list);
        this.listView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Channel channel = channelTreeExpandableListCollection.getChildElement(groupPosition, childPosition);
                onChannelSelectedListener.onChannelSelected(channel);
                return true;
            }
        });
    }

    @Override
    public void onDetach() {
        this.onChannelSelectedListener = null;
        super.onDetach();
    }

    public void addChannel(ChannelCategory category, Channel channel) {
        this.channelTreeExpandableListCollection.addChildElements(category, channel);
        this.adapter.notifyDataSetChanged();
    }

}
