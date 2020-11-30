package io.shapez;

import io.shapez.game.GameRoot;
import io.shapez.savegame.serialization.BasicSerializableObject;

public class BaseGameSpeed extends BasicSerializableObject {
    private GameRoot root;

    BaseGameSpeed(GameRoot root) {
        super();
        this.root = root;
        this.initializeAfterDeserialize(root);
    }

    private void initializeAfterDeserialize(GameRoot root) {
        this.root = root;
    }

    public static String getId() {
        return null;
    }
}
