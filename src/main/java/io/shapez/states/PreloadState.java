package io.shapez.states;

import io.shapez.GameCreationPayload;
import io.shapez.core.GameState;
import io.shapez.game.MapChunk;
import io.shapez.game.hud.parts.HUDModalDialogs;

public class PreloadState extends GameState {
    private HUDModalDialogs dialogs;
    private long lastHintShown;
    private int nextHintDuration;
    private String currentStatus;

    public PreloadState() {
        super("PreloadState");
    }

    @Override
    protected void onBackButton() {

    }

    @Override
    public void onRender(long dt) {
        this.update();
    }

    private void update() {
        long now = System.nanoTime();
        if (now - this.lastHintShown > this.nextHintDuration) {
            this.lastHintShown = now;
//            String hintText = getRandomHint(); // Idk what this does
            this.nextHintDuration = Math.max(2500, 60 * 1000);
        }
    }

    public String getThemeMusic() {
        return "menu";
    }

    @Override
    public void onEnter(GameCreationPayload payload) {
        this.dialogs = new HUDModalDialogs(null, this.app);
        this.lastHintShown = -1000;
        this.nextHintDuration = 0;
        this.currentStatus = "booting";
        this.startLoading();
    }

    @Override
    public void onBackgroundTick(long dt) {

    }

    void startLoading() {
        this.setStatus("Booting");
        this.setStatus("Initializing settings");
        this.app.settings.initialize();
        if (this.app.settings.getLanguage().equals("auto-detect")) {
            String language = "en";
            this.app.settings.updateLanguage(language);
        }
        String language = this.app.settings.getLanguage();
        updateApplicationLanguage(language);
        this.app.sound.initialize();
        this.app.backgroundResourceLoader.startLoading();
        this.app.restrictionMgr.initialize();
        this.app.savegameMgr.initialize();
        this.app.savegameMgr.writeAsync();
        this.moveToState("MainMenuState");
    }

    private void updateApplicationLanguage(String language) {
        String data = "en";
    }

    private void setStatus(String text) {
        this.currentStatus = text;
    }
}
