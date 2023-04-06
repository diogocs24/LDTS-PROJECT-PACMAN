package com.aor.pman.viewer.ghost;

import com.aor.pman.gui.GUI;
import com.aor.pman.model.ghost.Ghost;
import com.aor.pman.viewer.game.ElementViewer;

public class GhostInkyViewer implements ElementViewer<Ghost> {
    @Override
    public void draw(Ghost inkyGhost, GUI gui){gui.drawGhosts(inkyGhost.getPosition(), "#00FFFF");}
}