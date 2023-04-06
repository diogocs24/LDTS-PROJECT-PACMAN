package com.aor.pman.viewer.game;
import com.aor.pman.gui.GUI;
import com.aor.pman.model.game.Position;
import com.aor.pman.state.GameWonState;
import com.aor.pman.viewer.Viewer;

import java.io.IOException;

public class GameWinViewer extends Viewer {
    private boolean flag = true;
    public GameWinViewer(GUI gui) {
        super(gui);
    }

    @Override
    public void draw(GUI gui) throws IOException {
        gui.clear();
        gui.drawBackground(gui.createTextGraphics(), "#020721");
        gui.drawText(new Position(10, 10), "!YOU WON!", "#020721", "#00FF00");
        gui.drawText(new Position(9, 20), "PRESS ENTER", "#020721", "#FFFFFF");
        gui.drawText(new Position(5, 21), "TO GO BACK TO MENU", "#020721", "#FFFFFF");
        gui.refresh();

    }
}