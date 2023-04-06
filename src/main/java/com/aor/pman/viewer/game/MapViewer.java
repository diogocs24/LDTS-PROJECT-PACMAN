package com.aor.pman.viewer.game;

import com.aor.pman.gui.GUI;
import com.aor.pman.model.game.Element;
import com.aor.pman.model.game.Map;
import com.aor.pman.model.game.Position;
import com.aor.pman.viewer.ghost.GhostBlinkyViewer;
import com.aor.pman.viewer.ghost.GhostInkyViewer;
import com.aor.pman.viewer.ghost.GhostClydeViewer;
import com.aor.pman.viewer.ghost.GhostPinkyViewer;
import com.aor.pman.viewer.wall.*;

import java.util.List;

public class MapViewer {
    private final Map map;
    private final GUI gui;


    public MapViewer(GUI gui, Map map) {
        this.gui = gui;
        this.map = map;
    }

    public void draw() {
        gui.clear();
        gui.drawBackground(gui.createTextGraphics(), "#000000");
        drawElements(this.map.getWalls(), new WallViewer());
        drawElements(this.map.getCoins(), new CoinViewer());
        drawElement(this.map.getPinkyGhost(), new GhostPinkyViewer());
        drawElement(this.map.getInkyGhost(), new GhostInkyViewer());
        drawElement(this.map.getClydeGhost(), new GhostClydeViewer());
        drawElement(this.map.getBlinkyGhost(), new GhostBlinkyViewer());
        drawElement(this.map.getPlayer(), new PacmanViewer());
        gui.drawText(new Position(17, 0), "SCORE", "#000000", "#FFFFFF");
        gui.drawText(new Position(23, 0), map.getScore(), "#000000", "#FFFFFF");
        gui.drawText(new Position(1, 27), "LIVES:", "#000000", "#FFFFFF");
        if(map.getPacman().getLives() == 3) gui.drawText(new Position(7, 27), "kkk","#000000","#FF0000");
        else if(map.getPacman().getLives() == 2) gui.drawText(new Position(7, 27), "kk","#000000","#FF0000");
        else if(map.getPacman().getLives() == 1) gui.drawText(new Position(7, 27), "k","#000000","#FF0000");

    }

    public <T extends Element> void drawElements(List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(element, viewer);
    }

    public <T extends Element> void drawElement(T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }
}