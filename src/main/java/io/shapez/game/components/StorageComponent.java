package io.shapez.game.components;

import io.shapez.Component;
import io.shapez.game.BaseItem;

public class StorageComponent extends Component {
    private final int maximumStorage;
    BaseItem storedItem = null;
    int storedCount = 0;
    int overlayOpacity = 0;

    public static String getId() {
        return "Storage";
    }

    StorageComponent(int maximumStorage) {
        super();
        this.maximumStorage = maximumStorage;
    }
}
