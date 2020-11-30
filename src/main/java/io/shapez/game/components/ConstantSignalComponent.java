package io.shapez.game.components;

import io.shapez.Component;
import io.shapez.game.BaseItem;

public class ConstantSignalComponent extends Component {
    private final BaseItem signal;

    public static String getId() {
        return "ConstantSignal";
    }

    ConstantSignalComponent(BaseItem signal) {
        super();
        this.signal = signal;
    }
}
