package net.ichigotake.multipanestream.sdk;

import android.os.Parcel;
import android.text.TextUtils;

final class ChannelCategoryImpl implements ChannelCategory, android.os.Parcelable {

    private final String name;

    ChannelCategoryImpl(ChannelCategoryBuilder builder) {
        this.name = builder.name.toString();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        int result = 4;
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object object) {
        return this == object ||
                (object instanceof ChannelCategory && TextUtils.equals(name, ((ChannelCategory) object).getName()));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
    }

    private ChannelCategoryImpl(Parcel in) {
        this.name = in.readString();
    }

    public static final Creator<ChannelCategoryImpl> CREATOR = new Creator<ChannelCategoryImpl>() {
        public ChannelCategoryImpl createFromParcel(Parcel source) {
            return new ChannelCategoryImpl(source);
        }

        public ChannelCategoryImpl[] newArray(int size) {
            return new ChannelCategoryImpl[size];
        }
    };
}
