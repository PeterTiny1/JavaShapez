package io.shapez.game.components;

import io.shapez.Component;
import io.shapez.core.Direction;
import io.shapez.game.BeltPath;

public class BeltComponent extends Component {
    public final Direction direction;
    BeltPath assignedPath = null;

    public BeltComponent(Direction direction) {
        super();
        this.direction = direction;
    }

    public static String getId() {
        return "Belt";
    }
}
