package com.aor.pman.state;

import com.aor.pman.Game;
import com.aor.pman.gui.GUI;
import com.aor.pman.model.game.Map;
import com.aor.pman.model.menu.Menu;
import com.aor.pman.viewer.game.GameOverViewer;
import com.googlecode.lanterna.input.KeyStroke;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class GameOverState implements State{

    private Game game;
    private Menu menu;

    private GameOverViewer gameOverViewer;
    private GUI gui;

    public GameOverState(Game game) {
        this.game = game;
        gui = game.getGui();
        gameOverViewer = new GameOverViewer(gui);
        menu = game.getMenu();
    }

    @Override
    public void start(GUI gui) throws IOException {
        gameOverViewer.draw(gui);
    }

    @Override
    public void processInput(KeyStroke keystroke) throws IOException, URISyntaxException, FontFormatException {
        switch(keystroke.getKeyType()){
            case Enter -> {
                game.setMap(new Map(game.getWidth(), game.getHeight(), gui));
                game.setState(new MenuState(game, gui, menu));
            }

            case Escape -> gui.close();
        }
    }
}