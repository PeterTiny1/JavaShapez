package io.shapez.game;

import io.shapez.core.GlobalConfig;
import io.shapez.savegame.serialization.BasicSerializableObject;

import java.io.IOException;
import java.util.HashMap;

public class BaseMap extends BasicSerializableObject {
    private final GameRoot root;
    int seed = 0;
    HashMap<String, MapChunkView> chunksById = new HashMap<>();

    BaseMap(GameRoot root) {
        this.root = root;
    }

    public static String getId() {
        return "Map";
    }

    public Entity getLayerContentXY(float x, float y, String layer) throws IOException {
        MapChunkView chunk = this.getChunkAtTileOrNull(x, y);
        return chunk.getLayerContentFromWorldCoords(x, y, layer);
    }

    private MapChunkView getChunkAtTileOrNull(float tileX, float tileY) throws IOException {
        int chunkX = (int) Math.floor(tileX / GlobalConfig.mapChunkSize);
        int chunkY = (int) Math.floor(tileY / GlobalConfig.mapChunkSize);
        return this.getChunk(chunkX, chunkY, false);
    }

    private MapChunkView getChunk(int chunkX, int chunkY, boolean createIfNotExistent) throws IOException {
        String chunkIdentifier = chunkX + "|" + chunkY;
        MapChunkView storedChunk = null;
        if ((storedChunk == this.chunksById.get(chunkIdentifier))) {
            return storedChunk;
        }
        if (createIfNotExistent) {
            MapChunkView instance = new MapChunkView(this.root, chunkX, chunkY);
            this.chunksById.put(chunkIdentifier, instance);
            return instance;
        }
        return null;
    }
}
