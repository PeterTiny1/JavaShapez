package io.shapez.core;

import java.util.ArrayList;

public class Signal {
    ArrayList<Runnable> receivers = new ArrayList<>();
    int modifyCount = 0;

    public void add(Runnable consumer) {
        this.receivers.add(consumer);
        ++this.modifyCount;
    }

    public boolean dispatch() {
        int modifyState = this.modifyCount;
        int n = this.receivers.size();
        return true;
    }
}
