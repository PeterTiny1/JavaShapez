package io.shapez;

import java.util.ArrayList;

public class InputDistributor {
    ArrayList<InputReceiver> receiverStack = new ArrayList<>();
    ArrayList<Boolean> filters = new ArrayList<>();
    Set keysDown;
    Application app;

    InputDistributor(Application app) {
        this.app = app;
        this.bindToEvents();
    }

    void bindToEvents() {

    }

    public void popReceiver(InputReceiver receiver) {
        if (!this.receiverStack.contains(receiver)) {
            return;
        }
        this.receiverStack.remove(receiver);
    }

    public void pushReciever(InputReceiver receiver) {
        if (!this.isRecieverAttatched(receiver)) {
            this.receiverStack.add(receiver);
        }
    }

    private boolean isRecieverAttatched(InputReceiver receiver) {
        return this.receiverStack.contains(receiver);
    }

    public void installFilter(boolean boundInputFilter) {
        this.filters.add(boundInputFilter);
    }
}
