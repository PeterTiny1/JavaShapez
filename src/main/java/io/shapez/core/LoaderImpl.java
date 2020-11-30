package io.shapez.core;

import io.shapez.Application;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

public class LoaderImpl {
    Application app = null;
    HashMap<String, BaseSprite> sprites = new HashMap<>();
    ArrayList<Object> rawImages = new ArrayList<>();
    private AtlasSprite spriteNotFoundSprite = new AtlasSprite("");


    public void linkAppAfterBoot(Application app) {
        this.app = app;
        this.makeSpriteNotFoundCanvas();
    }

    private void makeSpriteNotFoundCanvas() {
        int dims = 128;
        BufferedImage canvas = new BufferedImage(dims, dims, BufferedImage.TYPE_INT_RGB);
        Graphics context = canvas.getGraphics();
        Graphics2D g2d = (Graphics2D) context;
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        context.setColor(new Color(0xFF7777));
        context.drawRect(0, 0, dims, dims);
//        context.textAlign(PConstants.CENTER); // Ignore because nonsense
        context.setColor(new Color(0xEEEEEE));
        context.setFont(new Font("Arial", Font.PLAIN, 32));
        context.drawString("???", dims / 2, dims / 2);
        AtlasSprite sprite = new AtlasSprite("not-found");
        for (String resolution : new String[]{"0.1", "0.25", "0.5", "0.75", "1"}) {
            sprite.linksByResolution.put(resolution, new SpriteAtlasLink(dims, dims, 0, 0, 0, 0, dims, dims, canvas));
        }
        this.spriteNotFoundSprite = sprite;
    }
}
