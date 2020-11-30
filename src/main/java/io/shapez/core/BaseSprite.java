package io.shapez.core;

import javax.swing.*;
import java.awt.*;

public abstract class BaseSprite {
    abstract Image getRawTexture();

    abstract void draw(JPanel context, int x, int y, int w, int h);
}
