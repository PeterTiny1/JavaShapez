package io.shapez.game.components;

import io.shapez.Component;
import io.shapez.core.Vector;

import java.util.ArrayList;

public class WiredPinsComponent extends Component {
    ArrayList<WirePinSlot> slots = new ArrayList<>();

    public static String getId() {
        return "WiredPins";
    }

    WiredPinsComponent(WirePinSlotDefinition[] slots) {
        super();
        this.setSlots(slots);
    }

    private void setSlots(WirePinSlotDefinition[] slots) {
        for (WirePinSlotDefinition slotData : slots) {
            this.slots.add(new WirePinSlot(slotData.pos, slotData.type, slotData.direction, null, null));
        }
    }
}

class WirePinSlotDefinition {
    Vector pos;
    String type;
    String direction;
}

