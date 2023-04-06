package com.aor.pman.model.menu;

import com.aor.pman.gui.GUI;
import com.aor.pman.model.game.Position;
import com.aor.pman.viewer.menu.MenuViewer;

import java.io.IOException;

public class Menu {
    protected GUI gui;
    protected MenuViewer menuViewer;
    private Pointer pointer;

    public Menu(GUI gui) {
        this.gui = gui;
        pointer = new Pointer(5, 14);
        menuViewer = new MenuViewer(gui);
    }

    public void draw() throws IOException {
        menuViewer.draw(gui);
    }

    public void movePointer(Position position){
        pointer.setPosition(position);
    }

    public Pointer getPointer() {
        return pointer;
    }
}
