package net.ichigotake.multipanestream.attribute.joiner;

import android.content.Context;
import android.widget.ArrayAdapter;

import net.ichigotake.multipanestream.sdk.Joiner;

import java.util.List;

public class JoinerAdapter extends ArrayAdapter<Joiner> {

    public JoinerAdapter(Context context, List<Joiner> joinerList) {
        super(context, android.R.layout.simple_list_item_1, joinerList);
    }
}
