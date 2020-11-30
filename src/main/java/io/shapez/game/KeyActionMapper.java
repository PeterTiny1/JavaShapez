package io.shapez.game;

import io.shapez.InputReceiver;
import io.shapez.Keybinding;
import io.shapez.core.Signal;

import java.util.HashMap;
import java.util.Map;

public class KeyActionMapper {
    GameRoot root;
    InputReceiver inputReceiver;
    HashMap<Integer, Keybinding> keybindings;
//    ApplicationSettings overrides = root.app.settings.getKeybindingOverrides();

    KeyActionMapper(GameRoot root, InputReceiver inputReceiver) {
        this.root = root;
        this.inputReceiver = inputReceiver;
//        Consumer handleKeydown = () -> handleKeydown();
//        inputReceiver.keydown.add(handleKeydown);
//        inputReceiver.keydown.add(handleKeyup);
    }

    private void handleKeydown(int keyCode, boolean initial) {
        boolean stop = false;
        for (Map.Entry<Integer, Keybinding> key : this.keybindings.entrySet()) {
            Keybinding binding = this.keybindings.get(key.getKey());
            if (binding.keyCode == keyCode && initial || binding.repeated) {
                Signal signal = this.keybindings.get(key.getKey()).signal;
                if (!signal.dispatch()) {
                    return;
                }
            }
        }
    }

    void handleKeyup() {

    }

    public Keybinding getBinding(int keyCode) {
        return this.keybindings.get(keyCode);
    }
}
