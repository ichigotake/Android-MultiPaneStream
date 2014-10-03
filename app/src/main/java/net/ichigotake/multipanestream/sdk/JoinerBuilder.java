package net.ichigotake.multipanestream.sdk;

public final class JoinerBuilder {

    CharSequence name;

    public Joiner build() {
        return new JoinerImpl(this);
    }

    public JoinerBuilder setName(CharSequence name) {
        this.name = name;
        return this;
    }

}
