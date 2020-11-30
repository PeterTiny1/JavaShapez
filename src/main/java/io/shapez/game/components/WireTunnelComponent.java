package io.shapez.game.components;

import io.shapez.Component;
import io.shapez.game.systems.WireNetwork;

import java.util.ArrayList;

public class WireTunnelComponent extends Component {
    ArrayList<WireNetwork> linkedNetworks = new ArrayList<>();

    public static String getId() {
        return "WireTunnel";
    }

    WireTunnelComponent() {
        super();
    }
}
