package net.ichigotake.multipanestream.sdk;

import android.os.Parcelable;

public interface Channel extends Parcelable {

    CharSequence getName();

    CharSequence getTopic();

}
