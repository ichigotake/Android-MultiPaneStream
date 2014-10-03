package net.ichigotake.multipanestream.sdk;

import android.os.Parcel;
import android.text.TextUtils;

final class ChannelImpl implements Channel, android.os.Parcelable {

    private final String name;
    private final String topic;

    ChannelImpl(ChannelBuilder builder) {
        this.name = builder.name.toString();
        this.topic = builder.topic.toString();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public CharSequence getTopic() {
        return topic;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object object) {
        return this == object ||
                (object instanceof Channel && TextUtils.equals(name, ((Channel) object).getName()));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.topic);
    }

    private ChannelImpl(Parcel in) {
        this.name = in.readString();
        this.topic = in.readString();
    }

    public static final Creator<ChannelImpl> CREATOR = new Creator<ChannelImpl>() {
        public ChannelImpl createFromParcel(Parcel source) {
            return new ChannelImpl(source);
        }

        public ChannelImpl[] newArray(int size) {
            return new ChannelImpl[size];
        }
    };
}
