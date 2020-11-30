package io.shapez.savegame;

import io.shapez.SettingsStorage;

import java.util.ArrayList;

public class SavegamesData {
    public int version;
    public SettingsStorage settings;
    ArrayList<SavegameMetadata> savegames = new ArrayList<>();

    SavegamesData(int version, ArrayList<SavegameMetadata> savegames) {
        this.savegames = savegames;
    }

    public SavegamesData(int version, boolean savegameV1119Imported) {

    }

    public SavegamesData() {

    }
}
