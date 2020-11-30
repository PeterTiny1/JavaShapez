package io.shapez.game.hud.parts;

import io.shapez.Application;
import io.shapez.game.GameRoot;
import io.shapez.game.hud.BaseHUDPart;

public class HUDModalDialogs extends BaseHUDPart {
    private final Application app;


    public HUDModalDialogs(GameRoot root, Application app) {
        super(root);
        this.app = app;
    }
}
