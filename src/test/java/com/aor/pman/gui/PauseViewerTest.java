package com.aor.pman.gui;

import com.aor.pman.model.game.Position;
import com.aor.pman.viewer.game.PauseViewer;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PauseViewerTest {
    @Test
    public void testDraw() throws IOException {
        // Create a mock GUI object
        GUI gui = mock(GUI.class);

        // Create a PauseViewer object using the mock GUI object
        PauseViewer pauseViewer = new PauseViewer(gui);

        // Call the draw method on the PauseViewer object
        pauseViewer.draw(gui);

        // Verify that the clear method was called on the GUI object
        verify(gui).clear();

        // Verify that the drawBackground method was called with the correct arguments on the GUI object
        verify(gui).drawBackground(gui.createTextGraphics(), "#020721");

        // Verify that the drawText method was called with the correct arguments on the GUI object
        verify(gui).drawText(new Position(12, 12), "PAUSE", "#020721", "#FFFF00");
        verify(gui).drawText(new Position(3, 21), "PRESS ANY KEY TO MENU", "#020721", "#FFFFFF");
        verify(gui).drawText(new Position(13, 23), "OR", "#020721", "#FFFFFF");
        verify(gui).drawText(new Position(4,25), "PRESS ESC TO RETURN", "#020721", "#FFFFFF");

        // Verify that the refresh method was called on the GUI object
        verify(gui).refresh();
    }

}
