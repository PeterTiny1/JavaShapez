package io.shapez.systems;

import io.shapez.game.GameRoot;
import io.shapez.game.GameSystemWithFilter;
import io.shapez.game.components.BeltComponent;

public class BeltSystem extends GameSystemWithFilter {
    BeltSystem(GameRoot root) {
        super(root, new BeltComponent[]{new BeltComponent(null)});
    }
}
