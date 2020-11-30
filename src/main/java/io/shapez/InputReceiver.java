package io.shapez;

import io.shapez.core.Signal;

public class InputReceiver {
    String context;
    public Signal backButton = new Signal();
    Signal keydown = new Signal();
    Signal keyup = new Signal();
    Signal pageBlur = new Signal();
    Signal destroyed = new Signal();

    public InputReceiver(String context) {
        this.context = context;
    }
}
