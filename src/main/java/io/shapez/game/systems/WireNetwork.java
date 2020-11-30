package io.shapez.game.systems;

import io.shapez.game.BaseItem;
import io.shapez.game.Entity;
import io.shapez.game.components.WirePinSlot;

import java.util.ArrayList;
import java.util.HashMap;

public class WireNetwork {
    HashMap<Entity, WirePinSlot> providers = new HashMap<>();
    HashMap<Entity, WirePinSlot> receivers = new HashMap<>();
    HashMap<Entity, WirePinSlot> allSlots = new HashMap<>();
    ArrayList<Entity> tunnels = new ArrayList<>();
    BaseItem currentValue = null;
    boolean valueConflict = false;
    int uid/* = ++networkUidCounter*/;
}
