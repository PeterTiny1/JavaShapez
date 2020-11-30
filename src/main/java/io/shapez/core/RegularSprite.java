package io.shapez.core;

import javax.swing.*;
import java.awt.*;

public class RegularSprite extends BaseSprite {
    private final int w;
    private final int h;
    private final Image sprite;

    RegularSprite(Image sprite, int w, int h) {
        this.w = w;
        this.h = h;
        this.sprite = sprite;
    }

    @Override
    Image getRawTexture() {
        return this.sprite;
    }

    @Override
    void draw(JPanel context, int x, int y, int w, int h) {
        context.getGraphics().drawImage(sprite, x, y, w, h, null);
    }
}
