package com.aor.pman.gui;

import com.aor.pman.model.game.Position;
import com.aor.pman.viewer.game.GameOverViewer;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GameOverViewerTest {
    @Test
    public void testDraw() throws IOException {
        // Create a mock GUI object
        GUI gui = mock(GUI.class);

        // Create a GameOverViewer object using the mock GUI object
        GameOverViewer gameOverViewer = new GameOverViewer(gui);

        // Call the draw method on the GameOverViewer object
        gameOverViewer.draw(gui);

        // Verify that the clear method was called on the GUI object
        verify(gui).clear();

        // Verify that the drawBackground method was called with the correct arguments on the GUI object
        verify(gui).drawBackground(gui.createTextGraphics(), "#020721");

        // Verify that the drawText method was called with the correct arguments on the GUI object
        verify(gui).drawText(new Position(9, 10), "!GAME OVER!", "#020721", "#FF0000");
        verify(gui).drawText(new Position(1, 19), "PRESS ENTER TO GO TO MENU", "#020721", "#FFFFFF");
        verify(gui).drawText(new Position(5, 20), "PRESS ESC TO EXIT", "#020721", "#FFFFFF");

        // Verify that the refresh method was called on the GUI object
        verify(gui).refresh();
    }

}
