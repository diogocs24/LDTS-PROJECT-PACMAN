package com.aor.pman.viewer.game;

import com.aor.pman.gui.GUI;
import com.aor.pman.model.game.Position;
import com.aor.pman.viewer.Viewer;

import java.io.IOException;

public class InstructionViewer extends Viewer {
    public InstructionViewer(GUI gui) {
        super(gui);
    }

    @Override
    public void draw(GUI gui) throws IOException {
        gui.clear();
        gui.drawBackground(gui.createTextGraphics(), "#020721");
        gui.drawText(new Position(10, 4), "RULES", "#020721", "#FFFF00");
        gui.drawText(new Position(1, 7), "%", "#020721", "#FF0000");
        gui.drawText(new Position(1, 8), "%", "#020721", "#FFA500");
        gui.drawText(new Position(1, 9), "%", "#020721", "#00FFFF");
        gui.drawText(new Position(3, 7), "COLLECT ALL COINS TO WIN",  "#020721", "#FFFFFF");
        gui.drawText(new Position(3, 8), "AVOIDING THE GHOSTS", "#020721", "#FFFFFF");
        gui.drawText(new Position(3, 9), "THAT WILL TRY TO EAT YOU", "#020721", "#FFFFFF");
        gui.drawText(new Position(1, 12), "%", "#020721", "#FFC0CB");
        gui.drawText(new Position(3, 12), "USE ARROWS TO MOVE", "#020721", "#FFFFFF");
        gui.drawText(new Position(1, 20), "PRESS ESC TO RETURN","#020721", "#FFFFFF" );
        gui.refresh();

    }
}