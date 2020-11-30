package io.shapez.game;

enum enumSavePriority {
    regular, asap
}

public class AutomaticSave {
    private final GameRoot root;
    enumSavePriority saveImportance = enumSavePriority.regular;
    int lastSaveAttempt = -1000;

    public AutomaticSave(GameRoot root) {
        this.root = root;
    }
}
