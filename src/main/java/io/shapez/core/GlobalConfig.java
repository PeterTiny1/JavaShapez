package io.shapez.core;

public class GlobalConfig {
    public static byte tileSize = 32;
    public static byte halfTileSize = 16;
    public static byte assetsDpi = 192 / 32;
    public static float assetsSharpness = 1.5f;
    public static float shapesSharpness = 1.4f;
    public static float statisticsGraphDpi = 2.5f;
    public static byte statisticsGraphSlices = 100;
    public static byte minimumTickRate = 25;
    public static short maximumTickRate = 500;
    public static byte mapChunkSize = 16;
    public static float mapChunkOverviewMinZoom = 0.9f;
    public static int mapChunkWorldSize = 0;
    public static byte beltItemsPerSecond = 2;
    public static byte minerSpeedPerSecond = 0;
    public static byte defaultItemTimer = 20;
    public static float itemSpacingOnBelts = 0.63f;
    public static byte wireItemsPerSecond = 6;
    public static byte[] undergroundMaxTilesPerTiers = {5, 9};
    public static byte readerAnalyzeIntervalSeconds = 10;

    public static class BuildingSpeeds {
        public static byte cutter = 1 / 4;
        public static byte cutterQuad = 1 / 4;
        public static byte rotator = 1;
        public static byte rotatorCCW = 1;
        public static byte rotator180 = 1;
        public static byte painter = 1 / 6;
        public static byte painterDouble = 1 / 8;
        public static byte painterQuad = 1 / 2;
        public static byte mixer = 1 / 5;
        public static byte stacker = 1 / 8;
    }

    public static float initialZoom = 1.9f;
    public static float minZoomLevel = 0.1f;
    public static byte maxZoomLevel = 3;
    public static byte gameSpeed = 1;
    public static float warmupTimeSecondsFast = 0.5f;
    public static byte warmupTimeSecondsRegular = 3;

    public static class Smoothing {
        boolean smoothMainCanvas = true;
        String quality = "low";
    }


}
