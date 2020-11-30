package io.shapez;

import io.shapez.game.GameRoot;

public class RegularGameSpeed extends BaseGameSpeed {

    RegularGameSpeed(GameRoot root) {
        super(root);
    }

    public static String getId() {
        return "regular";
    }

    int getTimeMultiplier() {
        return 1;
    }
}
