package io.shapez.core;

import io.shapez.game.GameRoot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class BufferMaintainer {
    private final float bufferGcDurationSeconds = 0.5f;
    private final GameRoot root;
    HashMap<String, HashMap<String, Integer>> cache = new HashMap<>();
    int iterationIndex = 1;
    int lastIteration = 0;

    public BufferMaintainer(GameRoot root) {
        this.root = root;
        this.root.gameFrameStarted.add(this::update);
    }

    public void update() {
        int now = this.root.time.realtimeNow();
        if (now - lastIteration > bufferGcDurationSeconds) {
            this.lastIteration = now;
            this.garbageCollect();
        }
    }

    void garbageCollect() {
        AtomicInteger totalKeys = new AtomicInteger();
        AtomicInteger deletedKeys = new AtomicInteger();
        int minIteration = this.iterationIndex;
        cache.forEach((key, subCache) -> {
            ArrayList<String> unusedSubKeys = new ArrayList<>();
            subCache.forEach((subKey, lastUse) -> {
                if (lastUse < minIteration) {
                    unusedSubKeys.add(subKey);
                    deletedKeys.getAndIncrement();
                } else {
                    totalKeys.incrementAndGet();
                }
            });

            for (String unusedSubKey : unusedSubKeys) {
                subCache.remove(unusedSubKey);
            }
        });
        ++this.iterationIndex;
    }
}
