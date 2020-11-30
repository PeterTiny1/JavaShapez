package io.shapez.core;

import io.shapez.Application;
import io.shapez.GameCreationPayload;

import java.util.HashMap;

public class StateManager {
    HashMap<String, GameState> stateClasses = new HashMap<>();
    GameState currentState = null;
    Application app;

    public StateManager(Application app) {
        this.app = app;
    }

    public void register(GameState stateClass) {
        String stateKey = stateClass.getKey();
        this.stateClasses.put(stateKey, stateClass);
    }

    public GameState getCurrentState() {
        return this.currentState;
    }

    public void moveToState(String key) {
        if (this.currentState != null) {
            if (key.equals(this.currentState.key)) {
                return;
            }
            this.currentState.internalLeaveCallback();
            this.currentState = null;
        }
        this.currentState = this.constructState(key);
        assert this.currentState != null;
        this.currentState.internalRegisterCallback(this, this.app);
        this.app.sound.playThemeMusic(this.currentState.getThemeMusic());
        this.currentState.internalEnterCallback();
    }

    private GameState constructState(String key) {
        if (this.stateClasses.get(key) != null) {
            return new GameState(key) {
                @Override
                protected void onBackButton() {

                }

                @Override
                public void onRender(long dt) {

                }

                @Override
                public void onEnter(GameCreationPayload payload) {

                }

                @Override
                public void onBackgroundTick(long dt) {

                }
            };
        }
        return null;
    }

//    private GameState constructState(String key) {
//        return new state();
//    }
}
