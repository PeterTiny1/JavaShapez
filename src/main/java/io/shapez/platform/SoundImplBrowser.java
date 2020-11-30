package io.shapez.platform;

import io.shapez.Application;

public class SoundImplBrowser extends SoundInterface {
    private static final String MusicInstance = null;
    private static final String WrappedSoundInstance = null;

    public SoundImplBrowser(Application app) {
        super(app, WrappedSoundInstance, MusicInstance);
    }
}

class WrappedSoundInstance extends SoundInstanceInterface {
    private final SoundSpritesContainer spriteContainer;

    WrappedSoundInstance(SoundSpritesContainer spriteContainer, String key) {
        super(key, "sfx.mp3");
        this.spriteContainer = spriteContainer;
    }

    @Override
    public void load() {

    }
}

class SoundSpritesContainer {

}

class MusicInstance extends MusicInstanceInterface {

    MusicInstance(String key, String url) {
        super(key, url);
    }

    @Override
    public void stop() {

    }

    @Override
    public void play(float volume) {

    }

    @Override
    public void load() {

    }
}