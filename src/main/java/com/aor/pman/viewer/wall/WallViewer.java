package com.aor.pman.viewer.wall;

import com.aor.pman.gui.GUI;
import com.aor.pman.model.wall.Wall;
import com.aor.pman.viewer.game.ElementViewer;

public class WallViewer implements ElementViewer<Wall> {

    @Override
    public void draw(Wall wall, GUI gui) {
        gui.drawWall(wall.getPosition(), "#3232CD");
    }
}
