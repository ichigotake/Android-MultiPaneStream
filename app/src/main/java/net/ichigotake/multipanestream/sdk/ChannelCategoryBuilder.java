package net.ichigotake.multipanestream.sdk;

public final class ChannelCategoryBuilder {

    CharSequence name;

    public ChannelCategory build() {
        return new ChannelCategoryImpl(this);
    }

    public ChannelCategoryBuilder setName(CharSequence name) {
        this.name = name;
        return this;
    }

}
