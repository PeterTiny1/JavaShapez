package io.shapez.game;

import java.util.ArrayList;

public class DynamicTickrate {

    private final GameRoot root;
    Long currentTickStart = null;
    ArrayList<Integer> capturedTicks = new ArrayList<>();
    int averageTickDuration = 0;
    int accumulatedFps = 0;
    int accumulatedFpsLastUpdate = 0;
    int averageFps = 60;
    int currentTickRate;
    private double deltaMs;
    private double deltaSeconds;

    DynamicTickrate(GameRoot root) {
        this.root = root;
        this.setTickRate(this.root.app.settings.getDesiredFps());
    }

    private void setTickRate(int rate) {
        this.currentTickRate = rate;
        this.deltaMs = 1000.0 / this.currentTickRate;
        this.deltaSeconds = 1.0 / this.currentTickRate;
    }

    public void beginTick() {
        this.currentTickStart = System.nanoTime();
        if (this.capturedTicks.size() > this.currentTickRate * 2) {
            capturedTicks.subList(0, 10).clear();
            capturedTicks.subList(this.capturedTicks.size() - 11, 10).clear();
            int average = 0;
            for (Integer capturedTick : this.capturedTicks) {
                average += capturedTick;
            }
            average /= this.capturedTicks.size();
            this.averageTickDuration = average;
            this.capturedTicks.clear();
        }
    }
}
