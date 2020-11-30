package io.shapez.game.components;

import io.shapez.core.Direction;

public class ItemAcceptorLocatedSlot {
    public int index;
    ItemAcceptorSlot slot;
    Direction acceptedDirection;

    public ItemAcceptorLocatedSlot(ItemAcceptorSlot slot, int index, Direction acceptedDirection) {
        this.slot = slot;
        this.index = index;
        this.acceptedDirection = acceptedDirection;
    }
}
