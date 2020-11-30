package io.shapez.game;

import java.util.HashMap;

public abstract class GameMode {
    private final GameRoot root;

    GameMode(GameRoot root) {
        this.root = root;
    }

    public abstract HashMap<String, TierRequirement[]> getUpgrades();

    public abstract LevelDefinition[] getLevelDefinitions();
}
