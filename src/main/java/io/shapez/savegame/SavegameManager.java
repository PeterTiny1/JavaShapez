package io.shapez.savegame;

import io.shapez.Application;
import io.shapez.core.ExplainedResult;
import io.shapez.core.ReadWriteProxy;

import java.util.ArrayList;

public class SavegameManager extends ReadWriteProxy {
    SavegamesData currentData = this.getDefaultData();

    public SavegameManager(Application app) {
        super(app, "savegames.bin");
    }

    public SavegamesData getDefaultData() {
        return new SavegamesData(this.getCurrentVersion(), new ArrayList<>());
    }

    @Override
    public ExplainedResult migrate() {
        return null;
    }

    @Override
    protected ExplainedResult verify(Object data) {
        return null;
    }

    public int getCurrentVersion() {
        return 1002;
    }

    public void initialize() {
        this.readAsync();
        this.updateAfterSavegamesChanged();
    }

    private void updateAfterSavegamesChanged() {
        this.sortSavegames();
    }

    private void sortSavegames() {
        this.currentData.savegames.sort((a, b) -> b.lastUpdate - a.lastUpdate);
        while (this.currentData.savegames.size() > 30) {
            SavegameMetadata toRemove = this.currentData.savegames.get(currentData.savegames.size() - 1);
            this.currentData.savegames.remove(currentData.savegames.size() - 1);
            Savegame game = new Savegame(this.app, toRemove.internalId, toRemove);
            game.deleteAsync();
        }
    }
}
