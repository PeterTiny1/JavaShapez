package io.shapez.game;

import io.shapez.systems.BeltSystem;

public class GameSystemManager {
    private final GameRoot root;
    BeltSystem belt = null;

    GameSystemManager(GameRoot root) {
        this.root = root;
    }
}
