package io.shapez.core;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class AtlasSprite extends BaseSprite {
    private final String spriteName;
    HashMap<String, SpriteAtlasLink> linksByResolution = new HashMap<>();

    public AtlasSprite(String spriteName) {
        super();
        this.spriteName = spriteName;
    }

    @Override
    Image getRawTexture() {
        return this.linksByResolution.get("0.75").atlas;
    }

    @Override
    void draw(JPanel context, int x, int y, int w, int h) {
        SpriteAtlasLink link = this.linksByResolution.get("0.75");
        int scaleW = w / link.w;
        int scaleH = h / link.w;
        context.getGraphics().drawImage(link.atlas, link.packedX, link.packedY, null);
    }
}
