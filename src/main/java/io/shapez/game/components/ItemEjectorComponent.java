package io.shapez.game.components;

import io.shapez.Component;
import io.shapez.core.Vector;
import io.shapez.game.BaseItem;
import io.shapez.game.BeltPath;
import io.shapez.game.Entity;

import java.util.ArrayList;

public class ItemEjectorComponent extends Component {
    private final boolean renderFloatingItems;
    private final ArrayList<ItemEjectorSlot> slots = new ArrayList<>();

    public static String getId() {
        return "ItemEjector";
    }

    public ItemEjectorComponent(Slot[] slots, boolean renderFloatingItems) {
        super();
        this.setSlots(slots);
        this.renderFloatingItems = renderFloatingItems;
    }

    void setSlots(Slot[] slots) {
        for (Slot slot : slots) {
            this.slots.add(new ItemEjectorSlot(slot.pos, slot.direction, null, 0, null, null));
        }
    }
}

class ItemEjectorSlot {
    Vector pos;
    String direction;
    BaseItem item;
    int progress;
    ItemAcceptorSlot cachedDestSlot;
    BeltPath cachedBeltPath;
    Entity cachedTargetEntity;

    public ItemEjectorSlot(Vector pos, String direction, BaseItem item, int progress, ItemAcceptorSlot cachedDestSlot, Entity cachedTargetEntity) {
        this.pos = pos;
        this.direction = direction;
        this.item = item;
        this.progress = progress;
        this.cachedDestSlot = cachedDestSlot;
        this.cachedTargetEntity = cachedTargetEntity;
    }
}

class Slot {
    Vector pos;
    String direction;
}
