package io.shapez;

import io.shapez.game.GameRoot;
import io.shapez.savegame.serialization.BasicSerializableObject;

public class GameTime extends BasicSerializableObject {
    private final GameRoot root;
    int timeSeconds = 0;
    int realtimeSeconds = 0;
    int realtimeAdjust = 0;
    BaseGameSpeed speed;
    int localTimeBudget;

    GameTime(GameRoot root) {
        super();
        this.root = root;
        speed = new RegularGameSpeed(this.root);
    }

    public int realtimeNow() {
        return this.realtimeSeconds;
    }

    public static String getId() {
        return "GameTime";
    }
}
