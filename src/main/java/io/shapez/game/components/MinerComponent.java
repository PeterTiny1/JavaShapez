package io.shapez.game.components;

import io.shapez.Component;
import io.shapez.game.BaseItem;
import io.shapez.game.Entity;

import java.util.ArrayList;

public class MinerComponent extends Component {
    private final int lastMiningTime;
    private final boolean chainable;
    ArrayList<BaseItem> itemChainBuffer = new ArrayList<>();
    BaseItem cachedMinedItem = null;
    Entity cachedChainedMiner = null;

    public static String getId() {
        return "Miner";
    }

    MinerComponent(boolean chainable) {
        super();
        this.lastMiningTime = 0;
        this.chainable = chainable;
    }
}
