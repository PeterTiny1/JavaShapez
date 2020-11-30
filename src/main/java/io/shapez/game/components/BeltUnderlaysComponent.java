package io.shapez.game.components;

import io.shapez.Component;
import io.shapez.core.Vector;

public class BeltUnderlaysComponent extends Component {
    private final BeltUnderlayTile[] underlays;

    public static String getId() {
        return "BeltUnderlays";
    }

    BeltUnderlaysComponent(BeltUnderlayTile[] underlays) {
        super();
        this.underlays = underlays;
    }
}

class BeltUnderlayTile {
    Vector pos;
    String direction;
    String cachedType;
}
