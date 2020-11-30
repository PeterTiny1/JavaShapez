package io.shapez.game.items;

import io.shapez.game.BaseItem;
import io.shapez.game.ShapeDefinition;

public class ShapeItem extends BaseItem {
    private final ShapeDefinition definition;

    public ShapeItem(ShapeDefinition definition) {
        super();
        this.definition = definition;
    }
}
