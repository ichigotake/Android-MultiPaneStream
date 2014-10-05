package net.ichigotake.multipanestream.attribute.channel;

import android.text.TextUtils;

import net.ichigotake.multipanestream.sdk.Channel;
import net.ichigotake.multipanestream.sdk.ChannelCategory;
import net.ichigotake.multipanestream.sdk.ChannelTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO: 設計を整理せねば
 */
class ChannelTreeExpandableListCollection {

    private final ChannelTree channelTree = new ChannelTree();
    private final List<Map<String, String>> groupList = new ArrayList<Map<String,String>>();
    private final List<List<Map<String, String>>> childList = new ArrayList<List<Map<String, String>>>();

    void addChildElements(ChannelCategory category, Channel channel) {
        if (!this.channelTree.containsChannelCategory(category)) {
            Map<String, String> groupElement = new HashMap<String, String>();
            groupElement.put(ChannelAdapter.KEY_GROUP_TITLE, category.getName().toString());
            this.groupList.add(groupElement);
        }

        if (!this.channelTree.getChannelList(category).contains(channel)) {
            List<Map<String, String>> childElements = getChildElements(category);
            Map<String, String> childValue = getChild(category);
            int groupPosition = getGroupPosition(category);
            if (groupPosition >= this.childList.size()) {
                this.childList.add(childElements);
            }
            if (!this.childList.get(groupPosition).contains(childValue)) {
                childValue.put(ChannelAdapter.KEY_CHILD_TITLE, channel.getName().toString());
                childValue.put(ChannelAdapter.KEY_CHILD_SUMMARY, channel.getTopic().toString());
                childElements.add(childValue);
            }
        }
        this.channelTree.addChannel(category, channel);
    }

    private Map<String, String> getChild(ChannelCategory category) {
        Map<String, String> child = new HashMap<String, String>();
        int groupPosition = getGroupPosition(category);
        if (groupPosition >= this.childList.size()) {
            return child;
        }
        for (Map<String, String> item : this.childList.get(groupPosition)) {
            if (this.groupList.contains(item)) {
                child.putAll(item);
            }
        }
        return child;
    }

    private int getGroupPosition(ChannelCategory category) {
        int groupPosition = 0;
        for (Map<String, String> entry : this.groupList) {
            if (TextUtils.equals(category.getName(), entry.get(ChannelAdapter.KEY_GROUP_TITLE))) {
                break;
            }
            groupPosition++;
        }
        return groupPosition;
    }

    private List<Map<String, String>> getChildElements(ChannelCategory category) {
        List<Map<String, String>> childElements = null;
        int groupPosition = 0;
        for (Map<String, String> entry : this.groupList) {
            if (TextUtils.equals(category.getName(), entry.get(ChannelAdapter.KEY_GROUP_TITLE))) {
                if (groupPosition >= this.childList.size()) {
                    childElements = new ArrayList<Map<String, String>>();
                } else {
                    childElements = this.childList.get(groupPosition);
                }
            }
            groupPosition++;
        }
        if (childElements == null) {
            childElements = new ArrayList<Map<String, String>>();
        }
        return childElements;
    }

    List<Map<String, String>> getGroupList() {
        return this.groupList;
    }

    List<List<Map<String, String>>> getChildElements() {
        return this.childList;
    }

    Channel getChildElement(int groupPosition, int childPosition) {
        String name = null;
        for (String label : this.groupList.get(groupPosition).values()) {
            name = label;
        }
        ChannelCategory category = this.channelTree.findCategory(name);
        //TODO: NPE 対策
        return channelTree.getChannelList(category).get(childPosition);
    }
}
