package io.shapez.game.components;

import io.shapez.Component;
import io.shapez.game.BaseItem;

import java.util.ArrayList;

public class FilterComponent extends Component {
    ArrayList<PendingFilterItem> pendingItemsToLeaveThrough = new ArrayList<>();
    ArrayList<PendingFilterItem> pendingItemsToReject = new ArrayList<>();

    public static String getId() {
        return "Filter";
    }

    FilterComponent() {
        super();
    }
}

class PendingFilterItem {
    BaseItem item;
    int progress;
}