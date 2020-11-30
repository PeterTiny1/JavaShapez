package io.shapez.platform;

public abstract class SoundInstanceInterface {
    String key;
    String url;

    SoundInstanceInterface(String key, String url) {
        this.key = key;
        this.url = url;
    }

    public abstract void load();
}
