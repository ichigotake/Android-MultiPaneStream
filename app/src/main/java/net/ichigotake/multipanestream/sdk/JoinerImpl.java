package net.ichigotake.multipanestream.sdk;

import android.os.Parcel;
import android.text.TextUtils;

final class JoinerImpl implements Joiner, android.os.Parcelable {

    private final String name;

    JoinerImpl(JoinerBuilder builder) {
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
    public boolean equals(Object object) {
        return this == object ||
                (object instanceof Joiner && TextUtils.equals(name, ((Joiner) object).getName()));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
    }

    private JoinerImpl(Parcel in) {
        this.name = in.readString();
    }

    public static final Creator<JoinerImpl> CREATOR = new Creator<JoinerImpl>() {
        public JoinerImpl createFromParcel(Parcel source) {
            return new JoinerImpl(source);
        }

        public JoinerImpl[] newArray(int size) {
            return new JoinerImpl[size];
        }
    };
}
