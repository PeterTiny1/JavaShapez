package io.shapez.game.components;

import io.shapez.Component;
import io.shapez.game.systems.WireNetwork;

import java.util.ArrayList;

public class WireComponent extends Component {
    private final String type;
    private final String variant;
    ArrayList<WireNetwork> linkedNetwork = new ArrayList<>();

    public static String getId() {
        return "Wire";
    }

    WireComponent(String type, String variant) {
        super();
        this.type = type;
        this.variant = variant;
    }
}
