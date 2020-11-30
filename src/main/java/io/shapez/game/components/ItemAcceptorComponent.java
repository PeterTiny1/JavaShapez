package io.shapez.game.components;

import io.shapez.Component;
import io.shapez.core.Vector;
import io.shapez.core.Direction;
import io.shapez.game.BaseItem;

import java.util.ArrayList;

public class ItemAcceptorComponent extends Component {
    ArrayList<ItemConsumptionAnimation> itemConsumptionAnimations = new ArrayList<>();
    private ArrayList<ItemAcceptorSlot> slots;

    public static String getId() {
        return "ItemAcceptor";
    }

    ItemAcceptorComponent(ItemAcceptorSlotConfig[] slots) {
        this.setSlots(slots);
    }

    private void setSlots(ItemAcceptorSlotConfig[] slots) {
        this.slots = new ArrayList<>();
        for (ItemAcceptorSlotConfig slot : slots) {
            this.slots.add(new ItemAcceptorSlot(slot.pos, slot.directions, slot.filter));
        }
    }

    public ItemAcceptorLocatedSlot findMatchingSlot(Vector targetLocalTile, Direction fromLocalDirection) {
        Direction desiredDirection = invertDirection(fromLocalDirection);
        for (int slotIndex = 0; slotIndex < this.slots.size(); ++slotIndex) {
            ItemAcceptorSlot slot = this.slots.get(slotIndex);
            if (!slot.pos.equals(targetLocalTile)) {
                continue;
            }
            for (int i = 0; i < slot.directions.length; ++i) {
                if (desiredDirection.equals(slot.directions[i])) {
                    return new ItemAcceptorLocatedSlot(slot, slotIndex, desiredDirection);
                }
            }
        }
        return null;
    }

    public Direction invertDirection(Direction direction) {
        switch (direction) {
            case top:
                return Direction.bottom;
            case right:
                return Direction.left;
            case bottom:
                return Direction.top;
            case left:
                return Direction.right;
            default:
                return null;
        }
    }
}

class ItemAcceptorSlotConfig {
    Vector pos;
    String[] directions;
    String filter;
}

class ItemConsumptionAnimation {
    BaseItem item;
    int slotIndex;
    int animProgress;
    String direction;
}

class ItemAcceptorSlot {
    Vector pos;
    String[] directions;
    String filter;

    public ItemAcceptorSlot(Vector pos, String[] directions, String filter) {
        this.pos = pos;
        this.directions = directions;
        this.filter = filter;
    }
}