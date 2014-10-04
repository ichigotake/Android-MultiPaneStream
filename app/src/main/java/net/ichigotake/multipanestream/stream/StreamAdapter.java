package net.ichigotake.multipanestream.stream;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import net.ichigotake.multipanestream.R;
import net.ichigotake.multipanestream.sdk.Message;

public class StreamAdapter extends ArrayAdapter<Message> {

    public StreamAdapter(Context context) {
        super(context, R.layout.message_item);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = new MessageView(getContext());
        }
        MessageView messageView = (MessageView) convertView;
        messageView.setMessage(getItem(position));
        return convertView;
    }

}
