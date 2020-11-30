package io.shapez.game;

import io.shapez.core.GlobalConfig;
import io.shapez.core.Signal;
import io.shapez.core.Vector;
import io.shapez.savegame.serialization.BasicSerializableObject;

import java.io.FileNotFoundException;

public class Camera extends BasicSerializableObject {
    GameRoot root;
    Integer zoomLevel = this.findInitialZoom();
    Vector center = new Vector(0, 0);
    boolean currentlyMoving = false;
    Vector lastMovingPosition = null;
    Vector lastMovingPositionLastTick = null;
    Integer numTicksStandingStill = null;
    double cameraUpdateTimeBucket = 0.0;
    boolean didMoveSinceTouchStart = false;
    boolean currentlyPinching = false;
    Vector lastPinchPositions = null;
    Vector keyboardForce = new Vector();
    Signal userInteraction = new Signal();
    Vector currentShake = new Vector(0, 0);
    Vector currentPan = new Vector(0, 0);
    Vector desiredPan = new Vector(0, 0);
    Vector desiredCenter = null;
    Double desiredZoom = null;
    Vector touchPostMoveVelocity = new Vector(0, 0);

    Camera(GameRoot root) throws FileNotFoundException {
        super();
        this.root = root;
        this.bindKeys();
    }

    private void bindKeys() {
        KeyActionMapper mapper = this.root.keyMapper;
        mapper.getBinding(KeyMappings.Navigation.MapMoveUp.keyCode).add(this::negY);
        mapper.getBinding(KeyMappings.Navigation.MapMoveDown.keyCode).add(this::posY);
        mapper.getBinding(KeyMappings.Navigation.MapMoveRight.keyCode).add(this::posX);
        mapper.getBinding(KeyMappings.Navigation.MapMoveLeft.keyCode).add(this::negX);
        mapper.getBinding(KeyMappings.Navigation.MapZoomIn.keyCode).add(this::zoomIn);
        mapper.getBinding(KeyMappings.Navigation.MapZoomOut.keyCode).add(this::zoomOut);
        mapper.getBinding(KeyMappings.Navigation.CenterMap.keyCode).add(this::centerOnMap);
    }

    private void centerOnMap() {
        this.desiredCenter = new Vector(0, 0);
    }

    int findInitialZoom() {
        int desiredWorldSpaceWidth = 15 * GlobalConfig.tileSize;
        int zoomLevelX = 1920 / desiredWorldSpaceWidth;
        int zoomLevelY = 1080 / desiredWorldSpaceWidth;
        return Math.min(zoomLevelX, zoomLevelY);
    }

    public static String getId() {
        return "Camera";
    }

    void negY() {
        this.keyboardForce.y = -1;
    }

    void posY() {
        this.keyboardForce.y = 1;
    }

    void negX() {
        this.keyboardForce.y = -1;
    }

    void posX() {
        this.keyboardForce.y = 1;
    }

    void zoomIn() {
        this.desiredZoom = this.zoomLevel * 1.2;
    }

    private void zoomOut() {
        this.desiredZoom = this.zoomLevel / 1.2;
    }
}
