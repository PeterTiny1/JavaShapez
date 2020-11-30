package io.shapez.core;

import java.util.function.Consumer;

public class AnimationFrame {
    public Signal frameEmitted = new Signal();
    public Signal bgFrameEmitted = new Signal();
    long lastTime = System.nanoTime();
    long bgLastTime = System.nanoTime();
    int maxDtMs = 1000;
    int resetDtMs = 16;
    public Consumer<Integer> boundMethod = this::handleAnimationFrame;

    public void handleAnimationFrame(long time) {
        int dt = (int) (time - this.lastTime);
        if (dt > maxDtMs) {
            dt = resetDtMs;
        }
        this.frameEmitted.dispatch();
        this.lastTime = time;
    }

    public void handleBackgroundTick() {
        long time = System.nanoTime();
        int dt = (int) (time - this.bgLastTime);
        if (dt > maxDtMs) {
            dt = resetDtMs;
        }
        this.bgFrameEmitted.dispatch();
        this.bgLastTime = time;
    }
}
