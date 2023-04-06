package com.aor.pman.state;

import com.aor.pman.Game;
import com.aor.pman.gui.GUI;
import com.aor.pman.model.game.Map;
import com.aor.pman.viewer.game.PauseViewer;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;

public class PauseState implements State {
    private final Game game;
    private final GUI gui;
    private final PauseViewer pauseViewer;

    public PauseState(Game game) {
        this.game = game;
        gui = game.getGui();
        pauseViewer = new PauseViewer(gui);
    }

    @Override
    public void start(GUI gui) throws IOException {
        pauseViewer.draw(gui);
    }

    @Override
    public void processInput(KeyStroke keystroke) throws IOException {
        switch (keystroke.getKeyType()){
            case Escape -> game.setState(new PlayState(game));
            case Enter, Character -> {
                game.setMap(new Map(game.getWidth(), game.getHeight(), gui));
                game.setState(new MenuState(game, gui, game.getMenu())); }
        }
    }
}
