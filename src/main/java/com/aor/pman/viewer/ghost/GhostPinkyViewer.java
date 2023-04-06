package com.aor.pman.viewer.ghost;

import com.aor.pman.gui.GUI;
import com.aor.pman.model.ghost.Ghost;
import com.aor.pman.viewer.game.ElementViewer;

public class GhostPinkyViewer implements ElementViewer<Ghost> {
    @Override
    public void draw(Ghost element, GUI gui) {
        gui.drawGhosts(element.getPosition(), "#FFC0CB");
    }
}
