package io.shapez.game;

import io.shapez.savegame.serialization.BasicSerializableObject;

import java.util.ArrayList;
import java.util.HashMap;

public class EntityManager extends BasicSerializableObject {
    GameRoot root;
    ArrayList<Entity> entities;
    ArrayList<Entity> destroyList;
    HashMap<String, ArrayList<Entity>> componentToEntity;
    int nextUid = 10000;

    EntityManager(GameRoot root) {
        super();
        this.root = root;
    }

    public static String getId() {
        return "EntityManager";
    }
}
