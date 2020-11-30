package io.shapez.game.components;

import io.shapez.Component;

public class LeverComponent extends Component {
    private final boolean toggled;

    public static String getId() {
        return "Lever";
    }

    LeverComponent(boolean toggled) {
        super();
        this.toggled = toggled;
    }
}
