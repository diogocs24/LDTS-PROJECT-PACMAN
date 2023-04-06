package com.aor.pman.gui;

import com.aor.pman.model.game.Position;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public interface GUI {

    enum PressedKey {UP,DOWN};

    TextGraphics createTextGraphics();

    void refresh() throws IOException;

    void clear();

    void close() throws IOException;

    Screen getScreen();

    void drawBackground(TextGraphics textGraphics, String color);

    void drawGhosts(Position position, String color);

    void drawPacmanUp(Position position, String color);
    void drawPacmanDown(Position position, String color);
    void drawPacmanLeft(Position position, String color);
    void drawPacmanRight(Position position, String color);

    void drawWall(Position position, String color);

    void drawCoin(Position position, String color);

    void drawText(Position position, String text, String backgroundColor, String textColor);

    void drawPointer(Position position, String pointerColor);

}