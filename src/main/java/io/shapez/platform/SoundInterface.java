package io.shapez.platform;

import io.shapez.Application;

import java.util.HashMap;

public class SoundInterface {

    private final Application app;
    Object soundClass;
    Object musicClass;
    HashMap<String, SoundInstanceInterface> sounds = new HashMap<>();
    HashMap<String, MusicInstanceInterface> music = new HashMap<>();
    MusicInstanceInterface currentMusic = null;
    boolean isVisible = true;
    float musicVolume = 1.0f;
    float soundVolume = 1.0f;

    SoundInterface(Application app, Object soundClass, Object musicClass) {
        this.app = app;
        this.soundClass = soundClass;
        this.musicClass = musicClass;
    }

    public void playThemeMusic(String key) {
        MusicInstanceInterface music = this.music.get(key);
        if (this.currentMusic != music) {
            this.currentMusic.stop();
            this.currentMusic = music;
            music.play(this.musicVolume);
        }
    }

    public void initialize() {
//        for (String soundKey : new String[]{"ui_click", "ui_error", "dialog_error", "dialog_ok", "ui_swish_hide", "ui_swish_show", "badge_notification", "level_complete", "destroy_building", "place_building", "place_belt", "copy"}) {
//            sound = new this.musicClass(soundKey);
//        }
//        whatever comes next
        this.musicVolume = this.app.settings.getAllSettings().musicVolume;
        this.soundVolume = this.app.settings.getAllSettings().soundVolume;
    }

    public void loadSound(String key) {
        if (this.sounds.get(key) != null) {
            this.sounds.get(key).load();
        } else if (this.music.get(key) != null) {
            this.music.get(key).load();
        }
    }
}
