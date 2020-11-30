package io.shapez;

import io.shapez.game.SubShape;

public class ShapeLayerItem {
    public SubShape subShape;
    public String colour;

    public ShapeLayerItem(SubShape shape, String colour) {
        this.subShape = shape;
        this.colour = colour;
    }
}
