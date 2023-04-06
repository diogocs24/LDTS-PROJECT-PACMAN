package com.aor.pman.viewer.menu;

import com.aor.pman.gui.GUI;
import com.aor.pman.model.game.Position;
import com.aor.pman.viewer.Viewer;
import com.aor.pman.model.menu.Menu;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.io.IOException;

public class MenuViewer extends Viewer {

    public MenuViewer(GUI gui) {
        super(gui);
    }

    public void draw(GUI gui, Menu menu) throws IOException {
        gui.drawBackground(gui.createTextGraphics(),"#020721");
        gui.drawText(new Position(10,6),"PAhMAN","#020721","#FFFF00");
        gui.drawText(new Position(11,14),"PLAY","#020721","#FFFFFF");
        gui.drawText(new Position(7,16),"INSTRUCTIONS","#020721","#FFFFFF");
        gui.drawText(new Position(11,18),"EXIT","#020721","#FF0000");
        gui.drawText(new Position(7,23),"LDTS - L02GR03","#020721","#040f45");
        drawPointer(gui, menu);
        gui.refresh();
    }

    public void drawPointer(GUI gui, Menu menu) throws IOException {
        gui.drawPointer(menu.getPointer().getPosition(), "#000000");
    }
}