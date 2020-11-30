package io.shapez;

import io.shapez.core.Signal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class BackgroundResourcesLoader {
    Application app;
    boolean registerReady = false;
    boolean mainMenuReady = false;
    boolean bareGameReady = false;
    boolean additionalReady = false;
    Signal signalMainMenuLoaded = new Signal();
    Signal signalBareGameLoaded = new Signal();
    Signal signalAdditionalLoaded = new Signal();
    int numAssetsLoaded = 0;
    int numAssetsToLoadTotal = 0;
    ArrayList<String> spritesLoaded = new ArrayList<>();
    ArrayList<String> soundsLoaded = new ArrayList<>();
    private String[] G_All_UI_IMAGES;

    public BackgroundResourcesLoader(Application app) {
        this.app = app;
    }

    public void startLoading() {
        this.internalStartLoadingEssentialsForMainMenu();
    }

    private void internalStartLoadingEssentialsForMainMenu() {
        String[] essentialMainMenuSprites = {"logo.png", String.valueOf(Arrays.stream(G_All_UI_IMAGES).filter(src -> src.startsWith("ui/")))};
        String[] essentialMainMenuSounds = {"ui_click", "ui_error", "dialog_error", "dialog_ok", "swish_show", "swish_hide"};
        this.internalLoadSpritesAndSounds(essentialMainMenuSprites, essentialMainMenuSounds);
    }

    private void internalLoadSpritesAndSounds(String[] sprites, String[] sounds) {
        this.numAssetsToLoadTotal = sprites.length + sounds.length;
        this.numAssetsLoaded = 0;
        for (int i = 0; i < sounds.length; ++i) {
            if (this.soundsLoaded.contains(sounds[i])) {
                continue;
            }
            this.soundsLoaded.add(sprites[i]);
            this.app.sound.loadSound(sounds[i]);
            this.numAssetsLoaded++;
        }
        for (int i = 0; i < sounds.length; ++i) {
            if (this.spritesLoaded.contains(sprites[i])) {
                continue;
            }
            this.spritesLoaded.add(sprites[i]);
            numAssetsLoaded++;
        }

    }
}
