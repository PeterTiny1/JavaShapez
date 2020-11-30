package io.shapez.game;

import io.shapez.savegame.serialization.BasicSerializableObject;

public class BaseItem extends BasicSerializableObject {
    public BaseItem() {
        super();
    }

    public static String getId() {
        return "base_item";
    }
}
