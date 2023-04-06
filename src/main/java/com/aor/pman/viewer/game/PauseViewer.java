package com.aor.pman.viewer.game;

import com.aor.pman.gui.GUI;
import com.aor.pman.model.game.Position;
import com.aor.pman.viewer.Viewer;

import java.io.IOException;

public class PauseViewer extends Viewer {
    public PauseViewer(GUI gui) {
        super(gui);
    }

    @Override
    public void draw(GUI gui) throws IOException {
        gui.clear();
        gui.drawBackground(gui.createTextGraphics(), "#020721");
        gui.drawText(new Position(12, 12), "PAUSE", "#020721", "#FFFF00");
        gui.drawText(new Position(3, 21), "PRESS ANY KEY TO MENU", "#020721", "#FFFFFF");
        gui.drawText(new Position(13, 23), "OR", "#020721", "#FFFFFF");
        gui.drawText(new Position(4,25), "PRESS ESC TO RETURN", "#020721", "#FFFFFF");
        gui.refresh();
    }
}