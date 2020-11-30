package io.shapez.game;

import io.shapez.ShapeLayer;
import io.shapez.ShapeLayerItem;
import io.shapez.savegame.serialization.BasicSerializableObject;

import java.util.ArrayList;

public class ShapeDefinition extends BasicSerializableObject {
    ShapeLayer[] layers;
    String cachedHash = null;

    public ShapeDefinition(Object[] layers) {
        this.layers = (ShapeLayer[]) layers;
    }

    public static ShapeDefinition fromShortKey(String key) {
        String[] sourceLayers = key.split(":");
        ArrayList<ShapeLayer[]> layers = new ArrayList<>();
        for (String text : sourceLayers) {
            ShapeLayer[] quads = {null, null, null, null};
            for (int quad = 0; quad < 4; ++quad) {
                char shapeText = text.charAt(quad * 2);
                char color = text.charAt(quad * 2 + 1);
            }
            layers.add(quads);
        }
        ShapeDefinition definition = new ShapeDefinition(layers.toArray());
        definition.cachedHash = key;
        return definition;
    }

    public String getHash() {
        if (this.cachedHash != null) {
            return this.cachedHash;
        }

        StringBuilder id = new StringBuilder();
        for (int layerIndex = 0; layerIndex < this.layers.length; ++layerIndex) {
            ShapeLayer layer = this.layers[layerIndex];
            for (int quadrant = 0; quadrant < layer.shapeLayerItems.length; ++quadrant) {
                ShapeLayerItem item = layer.shapeLayerItems[quadrant];
                if (item != null) {
                    switch (item.subShape) {
                        case rect:
                            id.append("R");
                            break;
                        case circle:
                            id.append("C");
                            break;
                        case star:
                            id.append("S");
                            break;
                        case windmill:
                            id.append("W");
                    }
                    switch (item.colour) {
                        case "red":
                            id.append("r");
                            break;
                        case "green":
                            id.append("g");
                            break;
                        case "blue":
                            id.append("b");
                            break;
                        case "yellow":
                            id.append("y");
                            break;
                        case "purple":
                            id.append("p");
                            break;
                        case "cyan":
                            id.append("c");
                            break;
                        case "white":
                            id.append("w");
                            break;
                        case "uncoloured":
                            id.append("u");
                    }
                } else {
                    id.append("--");
                }
            }
            if (layerIndex < this.layers.length - 1) {
                id.append(":");
            }
        }
        this.cachedHash = id.toString();
        return id.toString();
    }

    public static String getId() {
        return "ShapeDefinition";
    }
}