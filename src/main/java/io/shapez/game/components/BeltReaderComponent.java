package io.shapez.game.components;

import io.shapez.Component;
import io.shapez.game.BaseItem;

import java.util.ArrayList;

public class BeltReaderComponent extends Component {
    ArrayList<Integer> lastItemTimes = new ArrayList<>();
    BaseItem lastItem = null;
    int lastThroughput = 0;
    int lastThroughputComputation = 0;

    public static String getId() {
        return "BeltReader";
    }

    BeltReaderComponent() {
        super();
    }
}
