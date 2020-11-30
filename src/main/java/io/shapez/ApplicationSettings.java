package io.shapez;

import io.shapez.core.ExplainedResult;
import io.shapez.core.ReadWriteProxy;
import io.shapez.savegame.SavegamesData;

public class ApplicationSettings extends ReadWriteProxy {
    public ApplicationSettings(Application app) {
        super(app, "app_settings.bin");
    }

    public int getDesiredFps() {
        assert this.getAllSettings() != null;
        return Integer.parseInt(this.getAllSettings().refreshRate);
    }

    public SettingsStorage getAllSettings() {
        return this.currentData.settings;
    }

    public void initialize() {
        this.readAsync();
        SettingsStorage settings = this.getAllSettings();
    }

    public String getLanguage() {
        assert this.getAllSettings() != null;
        return this.getAllSettings().language;
    }

    public void updateLanguage(String id) {
        this.updateSetting("language", id);
    }

    private void updateSetting(String key, String value) {
    }

    @Override
    protected ExplainedResult verify(Object data) {
        return null;
    }

    @Override
    public int getCurrentVersion() {
        return 0;
    }

    @Override
    public SavegamesData getDefaultData() {
        return null;
    }

    @Override
    public ExplainedResult migrate() {
        return null;
    }

    void save() {
        this.writeAsync();
    }
}
