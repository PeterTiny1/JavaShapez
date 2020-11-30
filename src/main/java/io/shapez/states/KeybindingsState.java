package io.shapez.states;

import io.shapez.GameCreationPayload;
import io.shapez.core.TextualGameState;

public class KeybindingsState extends TextualGameState {
    public KeybindingsState() {
        super("KeybindingsState");
    }

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
}
