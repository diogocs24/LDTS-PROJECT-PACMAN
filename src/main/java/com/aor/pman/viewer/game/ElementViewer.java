package com.aor.pman.viewer.game;
import com.aor.pman.gui.GUI;
import com.aor.pman.model.game.Element;

public interface ElementViewer <T extends Element>{
    void draw(T element, GUI gui);
}