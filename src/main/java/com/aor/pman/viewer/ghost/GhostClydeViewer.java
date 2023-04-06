package com.aor.pman.viewer.ghost;

import com.aor.pman.gui.GUI;
import com.aor.pman.model.ghost.Ghost;
import com.aor.pman.viewer.game.ElementViewer;

public class GhostClydeViewer implements ElementViewer<Ghost> {
    @Override
    public void draw(Ghost clydeGhost, GUI gui){gui.drawGhosts(clydeGhost.getPosition(), "#FFA500");}
}

