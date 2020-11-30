package io.shapez.platform;

public abstract class MusicInstanceInterface {
    String key;
    String url;

    MusicInstanceInterface(String key, String url) {
        this.key = key;
        this.url = url;
    }

    public abstract void stop();

    public abstract void play(float volume);

    public abstract void load();
}
