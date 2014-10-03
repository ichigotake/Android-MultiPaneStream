package net.ichigotake.multipanestream.attribute.joiner;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.ichigotake.multipanestream.R;
import net.ichigotake.multipanestream.sdk.Joiner;

import java.util.ArrayList;
import java.util.List;

public final class JoinerFragment extends ListFragment {

    private final List<Joiner> joinerList = new ArrayList<Joiner>();
    private JoinerAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_joiner, parent, false);
        this.adapter = new JoinerAdapter(getActivity(), joinerList);
        setListAdapter(adapter);
        return view;
    }

    public void addJoiner(Joiner joiner) {
        if (!this.joinerList.contains(joiner)) {
            this.joinerList.add(joiner);
            this.adapter.notifyDataSetChanged();
        }
    }

}
