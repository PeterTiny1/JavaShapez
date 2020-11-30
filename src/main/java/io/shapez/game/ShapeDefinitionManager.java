package io.shapez.game;

import io.shapez.savegame.serialization.BasicSerializableObject;

import java.util.HashMap;

public class ShapeDefinitionManager extends BasicSerializableObject {
    final GameRoot root;
    HashMap<String, ShapeDefinition> shapeKeyToDefinition = new HashMap<>();
    HashMap<String, ShapeDefinition[]> operationCache = new HashMap<>();

    ShapeDefinitionManager(GameRoot root) {
        super();
        this.root = root;
    }

    public ShapeDefinition getShapeItemFromDefinition(ShapeDefinition definition) {
        return this.getShapeItemFromShortKey(definition.getHash());
    }

    public ShapeDefinition getShapeItemFromShortKey(String hash) {
        ShapeDefinition cached = this.shapeKeyToDefinition.get(hash);
        if (cached != null) {
            return cached;
        }
        return (ShapeDefinition.fromShortKey(hash));
    }

    public static String getId() {
        return "ShapeDefinitionManager";
    }

    public ShapeDefinition registerOrReturnHandle(ShapeDefinition definition) {
        String id = definition.getHash();
        if (this.shapeKeyToDefinition.get(id) != null) {
            return this.shapeKeyToDefinition.get(id);
        }
        this.shapeKeyToDefinition.put(id, definition);
        return definition;
    }
}
