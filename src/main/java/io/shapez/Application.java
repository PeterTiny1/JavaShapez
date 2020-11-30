package io.shapez;

import io.shapez.core.*;
import io.shapez.platform.SoundImplBrowser;
import io.shapez.platform.SoundInterface;
import io.shapez.platform.StorageInterface;
import io.shapez.savegame.SavegameManager;
import io.shapez.states.*;

import javax.swing.*;

public class Application {
    public final JPanel context;
    LoaderImpl loader = new LoaderImpl();
    public ApplicationSettings settings = new ApplicationSettings(this);
    AnimationFrame ticker = new AnimationFrame();
    public StateManager stateMgr = new StateManager(this);
    public SavegameManager savegameMgr = new SavegameManager(this);
    public InputDistributor inputMgr = new InputDistributor(this);
    public BackgroundResourcesLoader backgroundResourceLoader = new BackgroundResourcesLoader(this);
    public RestrictionManager restrictionMgr = new RestrictionManager(this);
    public StorageInterface storage = null;
    public SoundInterface sound = null;

    Application(JPanel context) {
        this.context = context;
        this.initPlatformDependentInstances();
    }

    private void initPlatformDependentInstances() {
        this.sound = new SoundImplBrowser(this);
    }

    void boot() {
        System.out.println("Booting...");
        this.registerStates();
        loader.linkAppAfterBoot(this);
        this.stateMgr.moveToState("PreloadState");
//        this.ticker.frameEmitted.add(onFrameEmitted());
//        this.ticker.bgFrameEmitted.add(onBackgroundFrame());
    }

    public void onBackgroundFrame(long dt) {
        GameState currentState = this.stateMgr.getCurrentState();
        if (currentState != null) {
            currentState.onBackgroundTick(dt);
        }
    }

    public void onFrameEmitted(long dt) {
//        long time = System.nanoTime();

        GameState currentState = this.stateMgr.getCurrentState();
        if (currentState != null) {
            currentState.onRender(dt);
        }
    }

    public void registerStates() {
        GameState[] states = {
                new PreloadState(),
                new MainMenuState(),
                new InGameState(),
                new SettingsState(),
                new KeybindingsState(),
                new AboutState(),
                new ChangelogState()
        };
        for (GameState state : states) {
            this.stateMgr.register(state);
        }
    }
}
