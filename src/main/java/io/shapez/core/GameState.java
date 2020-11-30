package io.shapez.core;

import io.shapez.Application;
import io.shapez.GameCreationPayload;
import io.shapez.InputReceiver;
import io.shapez.RequestChannel;

public abstract class GameState {
    public String key;
    boolean fadingOut;
    StateManager stateManager = null;
    InputReceiver inputReceiver;
    RequestChannel asyncChannel = new RequestChannel();
    public Application app = null;

    public GameState(String key) {
        this.key = key;
        inputReceiver = new InputReceiver("state-" + key);
        Runnable onBackButton = this::onBackButton;
        inputReceiver.backButton.add(onBackButton);
    }

    protected abstract void onBackButton();

    public String getKey() {
        return this.key;
    }

    public abstract void onRender(long dt);

    public void internalLeaveCallback() {
        this.app.inputMgr.popReceiver(this.inputReceiver);
    }

    public void internalRegisterCallback(StateManager stateManager, Application app) {
        this.stateManager = stateManager;
        this.app = app;
    }

    public String getThemeMusic() {
        return "menu";
    }

    public void internalEnterCallback() {
        this.app.inputMgr.pushReciever(this.inputReceiver);
    }

    public abstract void onEnter(GameCreationPayload payload);

    protected void moveToState(String stateKey) {
        if (this.fadingOut) {
            return;
        }

        int fadeTime = this.internalGetFadeInOutTime();
        boolean doFade = this.getHasFadeOut() && fadeTime != 0;
        if (doFade) {
            this.fadingOut = true;

        }
        this.stateManager.moveToState(stateKey);
    }

    protected boolean getHasFadeOut() {
        return true;
    }

    protected int internalGetFadeInOutTime() {
        return this.getInOutFadeTime();
    }

    protected int getInOutFadeTime() {
        return 200;
    }

    public abstract void onBackgroundTick(long dt);
}
