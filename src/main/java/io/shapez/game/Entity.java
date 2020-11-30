package io.shapez.game;

import io.shapez.EntityComponentStorage;
import io.shapez.savegame.serialization.BasicSerializableObject;

public class Entity extends BasicSerializableObject {
    private final GameRoot root;
    EntityComponentStorage components = new EntityComponentStorage();

    Entity(GameRoot root) {
        super();
        this.root = root;
    }

    public static String getId() {
        return "Entity";
    }
}
