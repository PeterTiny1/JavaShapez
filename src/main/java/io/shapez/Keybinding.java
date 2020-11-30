package io.shapez;

import io.shapez.core.Signal;
import io.shapez.game.KeyActionMapper;

public class Keybinding {
    KeyActionMapper keyMapper;
    public int keyCode;
    boolean builtin;
    public boolean repeated;
    public Signal signal = new Signal();
    Signal toggled = new Signal();

    public Keybinding(KeyActionMapper keyMapper, int keyCode, boolean builtin, boolean repeated) {
        this.keyMapper = keyMapper;
        this.keyCode = keyCode;
        this.builtin = builtin;
        this.repeated = repeated;
    }

    public void add(Runnable reciever) {
        this.signal.add(reciever);
    }
}
