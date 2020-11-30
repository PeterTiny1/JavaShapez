package io.shapez.game.components;

import io.shapez.Component;

public class LogicGateComponent extends Component {
    private final String type;

    public static String getId() {
        return "LogicGate";
    }

    LogicGateComponent(String type) {
        super();
        this.type = type;
    }
}
