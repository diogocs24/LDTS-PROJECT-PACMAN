package com.aor.pman.viewer.game;

import com.aor.pman.gui.GUI;
import com.aor.pman.model.game.Position;
import com.aor.pman.viewer.Viewer;

import java.io.IOException;

public class GameOverViewer extends Viewer {
    public GameOverViewer(GUI gui) {
        super(gui);
        MusicPlayer musicPlayer = new MusicPlayer("src/main/resources/music/Pacman-death.wav");
        musicPlayer.startMusic();
    }

    @Override
    public void draw(GUI gui) throws IOException {
        gui.clear();
        gui.drawBackground(gui.createTextGraphics(), "#020721");
        gui.drawText(new Position(9, 10), "!GAME OVER!", "#020721", "#FF0000");
        gui.drawText(new Position(1, 19), "PRESS ENTER TO GO TO MENU", "#020721", "#FFFFFF");
        gui.drawText(new Position(5, 20), "PRESS ESC TO EXIT", "#020721", "#FFFFFF");
        gui.refresh();
    }
}