package net.ichigotake.multipanestream.sdk;

import android.os.Parcel;

final class MessageImpl implements Message, android.os.Parcelable {

    private final long timestamp;
    private final String title;
    private final String body;
    private final Channel channel;
    private final Joiner author;

    public MessageImpl(MessageBuilder builder) {
        this.timestamp = builder.timestamp;
        this.title = builder.title.toString();
        this.body = builder.message.toString();
        this.channel = builder.channel;
        this.author = builder.author;
    }

    @Override
    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public CharSequence getTitle() {
        return title;
    }

    @Override
    public CharSequence getBody() {
        return body;
    }

    @Override
    public Channel getChannel() {
        return channel;
    }

    @Override
    public Joiner getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return String.format("%s[ %s ] %s: %s", timestamp, channel.getName(), title, body);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.timestamp);
        dest.writeString(this.title);
        dest.writeString(this.body);
        dest.writeParcelable(this.channel, 0);
        dest.writeParcelable(this.author, 0);
    }

    private MessageImpl(Parcel in) {
        this.timestamp = in.readLong();
        this.title = in.readString();
        this.body = in.readString();
        this.channel = in.readParcelable(Channel.class.getClassLoader());
        this.author = in.readParcelable(Joiner.class.getClassLoader());
    }

    public static final Creator<MessageImpl> CREATOR = new Creator<MessageImpl>() {
        public MessageImpl createFromParcel(Parcel source) {
            return new MessageImpl(source);
        }

        public MessageImpl[] newArray(int size) {
            return new MessageImpl[size];
        }
    };
}
