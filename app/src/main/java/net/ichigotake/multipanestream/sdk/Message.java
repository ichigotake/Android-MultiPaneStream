package net.ichigotake.multipanestream.sdk;

import android.os.Parcelable;

public interface Message extends Parcelable {

    long getTimestamp();

    CharSequence getTitle();

    CharSequence getBody();

    Channel getChannel();

    Joiner getAuthor();

}
