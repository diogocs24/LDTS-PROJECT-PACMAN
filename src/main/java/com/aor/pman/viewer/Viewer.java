package com.aor.pman.viewer;

import com.aor.pman.gui.GUI;

import java.io.IOException;

public abstract class Viewer {
    private final GUI gui;

    public Viewer(GUI gui) {
        this.gui = gui;
    }

    public void draw(GUI gui) throws IOException {};

}
