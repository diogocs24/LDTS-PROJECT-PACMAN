package com.aor.pman.viewer.game;

import com.aor.pman.gui.GUI;
import com.aor.pman.model.game.Pacman;

public class PacmanViewer implements ElementViewer<Pacman> {
    @Override
    public void draw(Pacman pacman, GUI gui) {
        if(pacman.getPacmanState() == "q") gui.drawPacmanUp(pacman.getPosition(), "#FFFF00");
        if(pacman.getPacmanState() == "r") gui.drawPacmanDown(pacman.getPosition(), "#FFFF00");
        if(pacman.getPacmanState() == "s") gui.drawPacmanLeft(pacman.getPosition(), "#FFFF00");
        if(pacman.getPacmanState() == "e") gui.drawPacmanRight(pacman.getPosition(), "#FFFF00");

    }
}
