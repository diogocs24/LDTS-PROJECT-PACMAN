package com.aor.pman.viewer.ghost;

import com.aor.pman.gui.GUI;
import com.aor.pman.model.ghost.Ghost;
import com.aor.pman.viewer.game.ElementViewer;

public class GhostBlinkyViewer implements ElementViewer<Ghost> {
    @Override
    public void draw(Ghost ghost, GUI gui) {
        gui.drawGhosts(ghost.getPosition(), "#FF0000");
    }
}