package io.shapez.core;

import io.shapez.Application;
import io.shapez.savegame.SavegamesData;

public class RestrictionManager extends ReadWriteProxy {
    SavegamesData currentData = this.getDefaultData();

    public SavegamesData getDefaultData() {
        return new SavegamesData(this.getCurrentVersion(), false);
    }

    @Override
    public ExplainedResult migrate() {
        return ExplainedResult.good();
    }

    @Override
    protected ExplainedResult verify(Object data) {
        return ExplainedResult.good();
    }

    public int getCurrentVersion() {
        return 1;
    }

    public RestrictionManager(Application app) {
        super(app, "restriction-flags.bin");
    }

    public void initialize() {
        this.readAsync();
    }
}
