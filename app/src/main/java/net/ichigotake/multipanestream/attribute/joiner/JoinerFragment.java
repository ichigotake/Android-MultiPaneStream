package net.ichigotake.multipanestream.attribute.joiner;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.ichigotake.multipanestream.R;

public final class JoinerFragment extends ListFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_joiner, parent, false);
    }
}
