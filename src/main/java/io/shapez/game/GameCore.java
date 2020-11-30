package io.shapez.game;

import io.shapez.Application;

public class GameCore {
    Application app;
    GameRoot root = null;
    boolean duringLogicUpdate = false;

    GameCore(Application app) {
        this.app = app;
    }

    boolean updateLogic() {
        GameRoot root = this.root;
        root.dynamicTickrate.beginTick();
        return true;
    }
}
