package net.ichigotake.multipanestream.stream;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.ichigotake.multipanestream.R;
import net.ichigotake.multipanestream.sdk.Channel;
import net.ichigotake.multipanestream.sdk.Message;

import java.util.List;

public final class MainStreamFragment extends ListFragment implements StreamContainer {

    private TextView topicView;
    private StreamAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_stream, parent, false);
        this.topicView = (TextView) view.findViewById(R.id.fragment_main_stream_topic);
        this.adapter = new StreamAdapter(getActivity());
        setListAdapter(adapter);
        return view;
    }

    public void setChannel(Channel channel) {
        topicView.setText(channel.getTopic());
        adapter.getFilter().filter(channel.toString());
    }

    @Override
    public void clearMessage() {
        adapter.clear();
    }

    @Override
    public void addMessage(Message message) {
        adapter.add(message);
    }

    @Override
    public void addMessageAll(List<Message> message) {
        adapter.addAll(message);
    }

}
