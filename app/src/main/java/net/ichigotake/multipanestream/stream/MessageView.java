package net.ichigotake.multipanestream.stream;

import android.content.Context;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import net.ichigotake.multipanestream.R;
import net.ichigotake.multipanestream.sdk.Message;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MessageView extends LinearLayout {

    @InjectView(R.id.message_item_timestamp)
    TextView messageItemTimestamp;
    @InjectView(R.id.message_item_channel)
    TextView messageItemChannel;
    @InjectView(R.id.message_item_title)
    TextView messageItemTitle;
    @InjectView(R.id.message_item_body)
    TextView messageItemBody;

    public MessageView(Context context) {
        super(context);
        init();
    }

    public MessageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MessageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.message_item, this, true);
        ButterKnife.inject(view);
    }

    public void setMessage(Message message) {
        messageItemTitle.setText(message.getTitle());
        messageItemBody.setText(message.getBody());
        messageItemChannel.setText("[" + message.getChannel().getName() + "]");
        messageItemTimestamp.setText(DateFormat.format("yyyy-MM-dd HH:mm", message.getTimestamp()));
    }
}
