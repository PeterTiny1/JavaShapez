package io.shapez.game;

import io.shapez.savegame.serialization.BasicSerializableObject;

public class ProductionAnalytics extends BasicSerializableObject {
    private final GameRoot root;

    public ProductionAnalytics(GameRoot root) {
        super();
        this.root = root;
    }

    public static String getId() {
        return "ProductionAnalytics";
    }
}
