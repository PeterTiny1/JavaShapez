package io.shapez.platform;

import io.shapez.Application;

public abstract class StorageInterface {
    private final Application app;

    StorageInterface(Application app) {
        this.app = app;
    }

    public abstract void readFileAsync(String filename);

    public abstract void deleteFileAsync(String filename);
}
