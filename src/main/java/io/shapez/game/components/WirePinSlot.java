package io.shapez.game.components;

import io.shapez.core.Vector;
import io.shapez.game.BaseItem;
import io.shapez.game.systems.WireNetwork;

public class WirePinSlot {
    Vector pos;
    String type;
    String direction;
    BaseItem value;
    WireNetwork linkedNetwork;

    public WirePinSlot(Vector pos, String type, String direction, BaseItem value, WireNetwork linkedNetwork) {
        this.pos = pos;
        this.type = type;
        this.direction = direction;
        this.value = value;
        this.linkedNetwork = linkedNetwork;
    }
}
