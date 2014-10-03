package net.ichigotake.multipanestream.stream;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.ichigotake.multipanestream.R;
import net.ichigotake.multipanestream.sdk.Message;

import java.util.List;

public final class LogStreamFragment extends ListFragment implements StreamContainer {

    private StreamAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_log_stream, parent, false);
        this.adapter = new StreamAdapter(getActivity());
        setListAdapter(adapter);
        return view;
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
