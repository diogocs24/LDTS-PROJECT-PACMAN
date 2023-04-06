package com.aor.pman.state;

import com.aor.pman.Game;
import com.aor.pman.gui.GUI;
import com.aor.pman.viewer.game.InstructionViewer;
import com.googlecode.lanterna.input.KeyStroke;
import com.aor.pman.model.menu.Menu;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class InstructionState implements State{

    private final Game game;
    private InstructionViewer instructionsViewer;
    private GUI gui;
    private Menu menu;

    public InstructionState(Game game, Menu menu) {
        gui = game.getGui();
        instructionsViewer = new InstructionViewer(gui);
        this.game = game;
        this.menu = menu;
    }

    @Override
    public void start(GUI gui) throws IOException {
        instructionsViewer.draw(gui);
    }


    @Override
    public void processInput(KeyStroke keystroke) throws IOException, URISyntaxException, FontFormatException {
        switch (keystroke.getKeyType()) {
            case Escape -> game.setState(new MenuState(game, gui, menu));
        }
    }
}