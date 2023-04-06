package com.aor.pman.state;
import com.aor.pman.Game;
import com.aor.pman.gui.GUI;
import com.aor.pman.model.game.Map;
import com.aor.pman.viewer.game.GameWinViewer;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;

public class GameWonState implements State{
    private final Game game;


    GameWinViewer gameWinViewer;
    GUI gui;


    public GameWonState(Game game) {
        gui = game.getGui();
        this.game = game;
        gameWinViewer = new GameWinViewer(gui);
    }

    @Override
    public void start(GUI gui) throws IOException {
        gameWinViewer.draw(gui);
    }

    @Override
    public void processInput(KeyStroke keystroke) throws IOException {
        switch(keystroke.getKeyType()){
            case Enter -> {
                game.setMap(new Map(game.getWidth(), game.getHeight(), gui));
                game.setState(new MenuState(game, gui, game.getMenu()));
            }
        }
    }
}