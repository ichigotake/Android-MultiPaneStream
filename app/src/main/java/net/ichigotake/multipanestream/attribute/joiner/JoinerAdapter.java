package net.ichigotake.multipanestream.attribute.joiner;

import android.content.Context;
import android.widget.ArrayAdapter;

import net.ichigotake.multipanestream.sdk.Joiner;

public class JoinerAdapter extends ArrayAdapter<Joiner> {

    public JoinerAdapter(Context context) {
        super(context, android.R.layout.simple_list_item_1);
    }
}
