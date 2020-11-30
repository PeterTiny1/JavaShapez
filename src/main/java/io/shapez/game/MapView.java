package io.shapez.game;

import com.google.gson.Gson;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import static io.shapez.core.GlobalConfig.tileSize;

public class MapView extends BaseMap {
    private final JPanel context;
    int backgroundCacheDPI = 2;
    Gson gson = new Gson();
    Reader reader = Files.newBufferedReader(Paths.get("res\\JSON\\themes\\light.json"));
    Map<?, ?> theme = gson.fromJson(reader, Map.class);
    int background = (int) theme.get("background");
    int gridLineWidth = (int) (((Map<?, ?>) (theme.get("map"))).get("gridLineWidth"));
    int grid = (int) (((Map<?, ?>) (theme.get("map"))).get("grid"));

    MapView(GameRoot root, JPanel context) throws IOException {
        super(root);
        this.context = context;
        this.internalInitializeCachedBackgroundCanvases();
    }

    void internalInitializeCachedBackgroundCanvases() {
        int dims = tileSize;
        int dpi = this.backgroundCacheDPI;
        AffineTransform at = new AffineTransform();
        at.scale(dpi, dpi);
        Graphics2D g2d = (Graphics2D) context.getGraphics();
        g2d.setTransform(at);
        context.getGraphics().setColor(new Color(background));
        context.getGraphics().drawRect(0, 0, dims, dims);
        int borderWidth = gridLineWidth;
        context.getGraphics().setColor(new Color(grid));
        context.getGraphics().fillRect(0, 0, dims, borderWidth);
        context.getGraphics().fillRect(0, borderWidth, borderWidth, dims);
        context.getGraphics().fillRect(dims - borderWidth, borderWidth, borderWidth, dims - 2 * borderWidth);
        context.getGraphics().fillRect(borderWidth, dims - borderWidth, dims, borderWidth);

    }
}
