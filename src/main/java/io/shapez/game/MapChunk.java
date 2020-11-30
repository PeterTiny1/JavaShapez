package io.shapez.game;

import io.shapez.ColorItem;
import io.shapez.Patches;
import io.shapez.Record;
import io.shapez.Rectangle;
import io.shapez.core.GlobalConfig;
import io.shapez.core.RandomNumberGenerator;
import io.shapez.core.Vector;
import io.shapez.game.items.ShapeItem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MapChunk {
    final GameRoot root;
    private final HashMap<String, ColorItem> color_item_singletons = new HashMap<>();
    int x;
    int y;
    int tileX;
    int tileY;

    BaseItem[][] lowerLayer = new BaseItem[GlobalConfig.mapChunkSize][GlobalConfig.mapChunkSize];
    Entity[][] contents = new Entity[GlobalConfig.mapChunkSize][GlobalConfig.mapChunkSize];
    Entity[][] wireContents = new Entity[GlobalConfig.mapChunkSize][GlobalConfig.mapChunkSize];
    ArrayList<Entity> containedEntities = new ArrayList<>();
    Rectangle tileSpaceRectangle = new Rectangle(
            this.tileX,
            this.tileY,
            GlobalConfig.mapChunkSize,
            GlobalConfig.mapChunkSize
    );
    Record<String, Entity[]> containedEntitiesByLayer;
    ArrayList<Patches> patches = new ArrayList<>();

    MapChunk(GameRoot root, int x, int y) throws IOException {
        this.root = root;
        this.x = x;
        this.y = y;
        this.tileX = x * GlobalConfig.mapChunkSize;
        this.tileY = y * GlobalConfig.mapChunkSize;
        Rectangle worldSpaceRectangle = new Rectangle(
                this.tileX * GlobalConfig.tileSize,
                this.tileY * GlobalConfig.tileSize,
                GlobalConfig.mapChunkWorldSize,
                GlobalConfig.mapChunkWorldSize
        );
        this.generateLowerLayer();
    }

    private void generateLowerLayer() {
        RandomNumberGenerator rng = new RandomNumberGenerator(this.x + "|" + this.y + "|" + this.root.map.seed);

        if (this.generatePredefined(rng)) {
            return;
        }
        Vector chunkCenter = new Vector(this.x, this.y).addScalar(.5f);
        int distanceToOriginInChunks = Math.round(chunkCenter.length());

        float colourPatchChance = (float) (0.9 - distanceToOriginInChunks / 25 * 0.5);
        if (rng.next() < colourPatchChance / 4) {
            int colorPatchSize = Math.max(2, Math.round(1 + distanceToOriginInChunks));
            this.internalGenerateColorPatch(rng, colorPatchSize, distanceToOriginInChunks);
        }
    }

    private void internalGenerateColorPatch(RandomNumberGenerator rng, int colorPatchSize, int distanceToOriginInChunks) {
        List<String> availableColours = Arrays.asList("red", "green");
        if (distanceToOriginInChunks > 2) {
            availableColours.add("blue");
        }
        this.internalGeneratePatch(rng, colorPatchSize, new ColorItem((String) rng.choice(availableColours.toArray())));
    }

    private boolean generatePredefined(RandomNumberGenerator rng) {
        if (this.x == 0 && this.y == 0) {
            this.internalGeneratePatch(rng, 2, color_item_singletons.get("red"), 7, 7);
            return true;
        }
        if (this.x == -1 && this.y == 0) {
            ShapeItem item = new ShapeItem(this.root.shapeDefinitionMgr.getShapeItemFromShortKey("CuCuCuCu"));
            this.internalGeneratePatch(rng, 2, item, GlobalConfig.mapChunkSize - 9, 7);
            return true;
        }
        if (this.x == 0 && this.y == -1) {
            ShapeItem item = new ShapeItem(this.root.shapeDefinitionMgr.getShapeItemFromShortKey("RuRuRuRu"));
            this.internalGeneratePatch(rng, 2, item, GlobalConfig.mapChunkSize - 9, 7);
            return true;
        }
        if (this.x == -1 && this.y == -1) {
            this.internalGeneratePatch(rng, 2, color_item_singletons.get("green"));
            return true;
        }
        if (this.x == 5 && this.y == -2) {
            ShapeItem item = new ShapeItem(this.root.shapeDefinitionMgr.getShapeItemFromShortKey("SuSuSuSu"));
            this.internalGeneratePatch(rng, 2, item, 5, GlobalConfig.mapChunkSize - 7);
            return true;
        }
        return false;
    }

    private void internalGeneratePatch(RandomNumberGenerator rng, int patchSize, BaseItem item, Integer overrideX, Integer overrideY) {
        int border = (int) Math.ceil(patchSize / 2 + 3);

        int patchX = rng.nextIntRange(border, GlobalConfig.mapChunkSize - border - 1);
        int patchY = rng.nextIntRange(border, GlobalConfig.mapChunkSize - border - 1);

        if (overrideX != null) {
            patchX = overrideX;
        }

        if (overrideY != null) {
            patchY = overrideY;
        }

        Vector avgPos = new Vector(0, 0);
        int patchesDrawn = 0;

        for (int i = 0; i <= patchSize; ++i) {
            int circleRadius = Math.min(1 + i, patchSize);
            int circleRadiusSquare = circleRadius * circleRadius;
            int circleOffsetRadius = (patchSize - i) / 2 + 2;

            float circleScaleX = rng.nextRange(0.9, 1.1);
            float circleScaleY = rng.nextRange(0.9, 1.1);

            int circleX = patchX + rng.nextIntRange(-circleOffsetRadius, circleOffsetRadius);
            int circleY = patchY + rng.nextIntRange(-circleOffsetRadius, circleOffsetRadius);

            for (float dx = (-circleRadius * circleScaleX - 2); dx <= circleRadius * circleScaleX + 2; ++dx) {
                for (float dy = (-circleRadius * circleScaleY - 2); dy <= circleRadius * circleScaleY + 2; ++dy) {
                    int x = Math.round(circleX + dx);
                    int y = Math.round(circleY + dy);
                    if (x >= 0 && x < GlobalConfig.mapChunkSize && y >= 0 && y <= GlobalConfig.mapChunkSize) {
                        float originalDx = dx / circleScaleX;
                        float originalDy = dy / circleScaleY;
                        if (originalDx * originalDx + originalDy * originalDy <= circleRadiusSquare) {
                            if (this.lowerLayer[x][y] != null) {
                                this.lowerLayer[x][y] = item;
                                ++patchesDrawn;
                                avgPos.x += x;
                                avgPos.y += y;
                            }
                        }
                    }
                }
            }
        }
        this.patches.add(new Patches(avgPos.divideScalar(patchesDrawn), item, patchSize));
    }

    private void internalGeneratePatch(RandomNumberGenerator rng, int patchSize, BaseItem item) {
        int border = (int) Math.ceil(patchSize / 2 + 3);

        int patchX = rng.nextIntRange(border, GlobalConfig.mapChunkSize - border - 1);
        int patchY = rng.nextIntRange(border, GlobalConfig.mapChunkSize - border - 1);

        Vector avgPos = new Vector(0, 0);
        int patchesDrawn = 0;

        for (int i = 0; i <= patchSize; ++i) {
            int circleRadius = Math.min(1 + i, patchSize);
            int circleRadiusSquare = circleRadius * circleRadius;
            int circleOffsetRadius = (patchSize - i) / 2 + 2;

            float circleScaleX = rng.nextRange(0.9, 1.1);
            float circleScaleY = rng.nextRange(0.9, 1.1);

            int circleX = patchX + rng.nextIntRange(-circleOffsetRadius, circleOffsetRadius);
            int circleY = patchY + rng.nextIntRange(-circleOffsetRadius, circleOffsetRadius);

            for (float dx = (-circleRadius * circleScaleX - 2); dx <= circleRadius * circleScaleX + 2; ++dx) {
                for (float dy = (-circleRadius * circleScaleY - 2); dy <= circleRadius * circleScaleY + 2; ++dy) {
                    int x = Math.round(circleX + dx);
                    int y = Math.round(circleY + dy);
                    if (x >= 0 && x < GlobalConfig.mapChunkSize && y >= 0 && y <= GlobalConfig.mapChunkSize) {
                        float originalDx = dx / circleScaleX;
                        float originalDy = dy / circleScaleY;
                        if (originalDx * originalDx + originalDy * originalDy <= circleRadiusSquare) {
                            if (this.lowerLayer[x][y] != null) {
                                this.lowerLayer[x][y] = item;
                                ++patchesDrawn;
                                avgPos.x += x;
                                avgPos.y += y;
                            }
                        }
                    }
                }
            }
        }
        this.patches.add(new Patches(avgPos.divideScalar(patchesDrawn), item, patchSize));
    }

    public Entity getLayerContentFromWorldCoords(float worldX, float worldY, String layer) {
        float localX = worldX - this.tileX;
        float localY = worldY - this.tileY;
        if (layer.equals("regular")) {
            return this.contents[(int) localX][(int) localY];
        } else {
            return this.wireContents[(int) localX][(int) localY];
        }
    }
}

enum enumColours {

}
