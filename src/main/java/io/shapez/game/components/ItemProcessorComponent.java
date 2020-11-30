package io.shapez.game.components;

import io.shapez.Component;
import io.shapez.game.BaseItem;

import java.util.ArrayList;
import java.util.HashMap;

public class ItemProcessorComponent extends Component {
    private final String type;
    private final int inputsPerCharge;
    int nextOutputSlot = 0;
    HashMap<BaseItem, Integer> inputSlots = new HashMap<>();
    ArrayList<EjectorCharge> ejectorCharges = new ArrayList<>();
    int bonusTime = 0;

    public static String getId() {
        return "ItemProcessor";
    }

    ItemProcessorComponent(String processorType, String processingRequirement, int inputsPerCharge) {
        super();
        this.type = processorType;
        this.inputsPerCharge = inputsPerCharge;
    }
}

class EjectorCharge {
    int remainingTime;
    EjectorItemToEject[] items;
}

class EjectorItemToEject {
    BaseItem item;
    int requiredSlot;
    int preferredSlot;
}
