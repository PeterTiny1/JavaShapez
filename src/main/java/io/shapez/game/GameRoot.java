package io.shapez.game;

import io.shapez.Application;
import io.shapez.GameLogic;
import io.shapez.GameTime;
import io.shapez.core.BufferMaintainer;
import io.shapez.core.Signal;
import io.shapez.game.hud.GameHUD;
import io.shapez.savegame.Savegame;
import io.shapez.states.InGameState;

public class GameRoot {
    public Application app;
    Savegame savegame = null;
    InGameState gameState = null;
    public KeyActionMapper keyMapper = null;
    boolean gameIsFresh = true;
    boolean logicInitialised = false;
    boolean gameInitialised = false;
    boolean bulkOperationRunning = false;
    Camera camera = null;
    public MapView map = null;
    GameLogic logic = null;
    EntityManager entityMgr = null;
    GameHUD hud = null;
    GameSystemManager systemMgr = null;
    public GameTime time = null;
    HubGoals hubGoals = null;
    BufferMaintainer buffers = null;
    AutomaticSave automaticSave = null;
    SoundProxy soundProxy = null;
    ShapeDefinitionManager shapeDefinitionMgr = null;
    ProductionAnalytics productionAnalytics = null;
    public DynamicTickrate dynamicTickrate = null;
    String currentLayer = "regular";
    public GameMode gameMode = null;
    public Signal entityAdded = new Signal();
    public Signal gameFrameStarted = new Signal();

    public GameRoot(Application app) {
        this.app = app;
    }
}
