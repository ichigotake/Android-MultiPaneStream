package net.ichigotake.multipanestream.stream;

import android.content.Context;
import android.widget.ArrayAdapter;

import net.ichigotake.multipanestream.sdk.Message;

public class StreamAdapter extends ArrayAdapter<Message> {

    public StreamAdapter(Context context) {
        super(context, android.R.layout.simple_list_item_1);
    }

}
