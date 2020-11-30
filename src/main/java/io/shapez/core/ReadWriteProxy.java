package io.shapez.core;

import io.shapez.Application;
import io.shapez.savegame.SavegamesData;

public abstract class ReadWriteProxy {
    protected final Application app;
    String filename;
    public SavegamesData currentData = null;

    public ReadWriteProxy(Application app, String filename) {
        this.app = app;
        this.filename = filename;
    }

    protected void readAsync() {
        this.app.storage.readFileAsync(this.filename);
    }

    public void deleteAsync() {
        this.app.storage.deleteFileAsync(this.filename);
    }

    public void writeAsync() {
        ExplainedResult verifyResult = this.internalVerifyEntry(this.currentData);
    }

    private ExplainedResult internalVerifyEntry(SavegamesData data) {
        if (data.version != this.getCurrentVersion()) {
            return ExplainedResult.bad("Version mismatch, got " + data.version + " and expected " + this.getCurrentVersion());
        }
        ExplainedResult verifyStructureError = this.internalVerifyBasicStructure(data);
        if (!verifyStructureError.isGood()) {
            return verifyStructureError;
        }
        return this.verify(data);
    }

    protected abstract ExplainedResult verify(Object data);

    protected ExplainedResult internalVerifyBasicStructure(SavegamesData data) {
        if (data == null) {
            return ExplainedResult.bad("Data is empty", new Object[]{});
        }
        if (data.version < 0) {
            return ExplainedResult.bad("Data has invalid version: ${data.version} (expected ${this.getCurrentVersion()})", new Object[]{});
        }
        return ExplainedResult.good();
    }

    public abstract int getCurrentVersion();

    public abstract SavegamesData getDefaultData();

    void resetEverythingAsync() {
        this.currentData = this.getDefaultData();
        this.writeAsync();
    }

    public abstract ExplainedResult migrate();
}
