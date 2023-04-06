package com.aor.pman.state;

import com.aor.pman.Game;
import com.aor.pman.gui.GUI;
import com.aor.pman.model.game.Position;
import com.aor.pman.model.menu.Menu;
import com.aor.pman.viewer.menu.MenuViewer;
import com.googlecode.lanterna.input.KeyStroke;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class MenuState  implements State {
    private final GUI gui;
    private final Game game;
    private MenuViewer menuViewer;
    private Menu menu;

    public MenuState(Game game, GUI gui, Menu menu) {
        this.gui = gui;
        this.menu = menu;
        this.game = game;
        menuViewer = new MenuViewer(gui);
    }



    @Override
    public void start(GUI gui) throws IOException {
        menuViewer.draw(gui, menu);
    }

    public Menu getMenu() {
        return menu;
    }

    @Override
    public void processInput(KeyStroke keystroke) throws IOException, URISyntaxException, FontFormatException {
        System.out.println(keystroke);

        switch (keystroke.getKeyType()) {
            case ArrowDown -> {
                if (menu.getPointer().getPosition().getY() + 2 <= 18)
                    menu.getPointer().setPosition(new Position(menu.getPointer().getPosition().getX(), menu.getPointer().getPosition().getY() + 2));
            }

            case ArrowUp -> {
                if (menu.getPointer().getPosition().getY() - 2 >= 14)
                    menu.getPointer().setPosition(new Position(menu.getPointer().getPosition().getX(), menu.getPointer().getPosition().getY() - 2));

            }

            case Enter -> {
                if(menu.getPointer().getPosition().getY() == 14)
                    game.setState(new PlayState(game));
                if(menu.getPointer().getPosition().getY() == 16)
                    game.setState(new InstructionState(game, menu));
                if(menu.getPointer().getPosition().getY() == 18)
                    gui.close();
            }
        }
    }
}
