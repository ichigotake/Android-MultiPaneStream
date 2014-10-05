package net.ichigotake.multipanestream.attribute.channel;

import android.content.Context;
import android.widget.SimpleExpandableListAdapter;

import net.ichigotake.multipanestream.R;

class ChannelAdapter extends SimpleExpandableListAdapter {

    static final String KEY_GROUP_TITLE = "GROUP_TITLE";
    static final String KEY_CHILD_TITLE = "CHILD_TITLE";
    static final String KEY_CHILD_SUMMARY = "SUMMARY";

    ChannelAdapter(Context context, ChannelTreeExpandableListCollection collection) {
        super(
                context,
                collection.getGroupList(),
                R.layout.channel_tree_category_group,
                new String []{KEY_GROUP_TITLE},
                new int []{R.id.channel_tree_category_group_name},
                collection.getChildElements(),
                R.layout.channel_tree_category_child,
                new String []{KEY_CHILD_TITLE, KEY_CHILD_SUMMARY},
                new int []{R.id.channel_tree_category_child_name, R.id.channel_tree_category_child_topic}
        );
    }
}
