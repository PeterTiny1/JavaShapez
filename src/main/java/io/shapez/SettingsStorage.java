package io.shapez;

import java.util.HashMap;

public class SettingsStorage {
    String uiScale = "regular";
    public float soundVolume = 1.0f;
    public float musicVolume = 1.0f;
    String theme = "light";
    String refreshRate = "60";
    String scrollWheelIntensity = "regular";
    String movementSpeed = "regular";
    String language = "auto-detect";
    String autosaveInterval = "two_minutes";
    boolean alwaysMultiplace = false;
    boolean offerHints = true;
    boolean enableTunnelSmartplace = true;
    boolean vignette = true;
    boolean compactedBuildingInfo = true;
    boolean disableCutDeleteWarnings = false;
    boolean rotationByBuilding = true;
    boolean clearCursorOnDeleteWhilePlacing = false;
    boolean displayChunkBorders = false;
    boolean pickMinerOnPath = true;
    boolean enableMousePan = true;
    boolean enableColorBlindHelper = false;
    boolean lowQualityMapResources = false;
    boolean disableTileGrid = false;
    boolean lowQualityTextures = false;
    boolean simplifiedBelts = false;
    boolean zoomToCursor = true;
    float mapResourcesScale = 0.5f;
    HashMap<String, Integer> keybindingOverrides = new HashMap<>();
}
