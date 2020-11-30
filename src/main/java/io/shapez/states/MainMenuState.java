package io.shapez.states;

import io.shapez.GameCreationPayload;
import io.shapez.core.GameState;
import io.shapez.game.hud.parts.HUDModalDialogs;

public class MainMenuState extends GameState {
    HUDModalDialogs dialogs;

    public MainMenuState() {
        super("MainMenuState");
    }

    @Override
    protected void onBackButton() {

    }

    @Override
    public void onRender(long dt) {
        System.out.println("render");
    }

    @Override
    public void onEnter(GameCreationPayload payload) {
        this.dialogs = new HUDModalDialogs(null, this.app);

    }

    @Override
    public void onBackgroundTick(long dt) {

    }
}
