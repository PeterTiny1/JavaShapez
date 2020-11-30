package io.shapez.game.components;

import io.shapez.Component;
import io.shapez.game.BaseItem;
import io.shapez.game.Entity;

import java.util.ArrayList;
import java.util.HashMap;

public class UndergroundBeltComponent extends Component {
    private final int tier;
    private final String mode;
    ArrayList<ItemConsumptionAnimation> consumptionAnimations = new ArrayList<>();
    HashMap<BaseItem, Integer> pendingItems = new HashMap<>();
    LinkedUndergroundBelt cachedLinkedEntity = null;

    public static String getId() {
        return "UndergroundBelt";
    }

    UndergroundBeltComponent(String mode, int tier) {
        super();
        this.tier = tier;
        this.mode = mode;

    }
}

class LinkedUndergroundBelt {
    Entity entity;
    int distance;
}
