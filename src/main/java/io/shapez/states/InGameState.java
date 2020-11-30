package io.shapez.states;

import io.shapez.GameCreationPayload;
import io.shapez.core.GameState;
import io.shapez.game.GameCore;
import io.shapez.game.GameLoadingOverlay;
import io.shapez.savegame.Savegame;

public class InGameState extends GameState {
    GameCreationPayload creationPayload = null;
    String stage = "";
    GameCore core = null;
    boolean boundInputFilter = filterInput();
    private Savegame savegame;
    private GameLoadingOverlay loadingOverlay;

    public InGameState() {
        super("InGameState");
    }

    @Override
    protected void onBackButton() {

    }

    @Override
    public void onRender(long dt) {

    }

    @Override
    public void onEnter(GameCreationPayload payload) {
        this.app.inputMgr.installFilter(this.boundInputFilter);
        this.savegame = payload.savegame;
        this.loadingOverlay = new GameLoadingOverlay(this.app);
    }

    @Override
    public void onBackgroundTick(long dt) {

    }

    public boolean filterInput() {
        return this.stage.equals("\uD83C\uDF08 10: Game finally running");
    }
}
