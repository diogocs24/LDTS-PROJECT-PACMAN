package com.aor.pman.gui;

import com.aor.pman.model.game.Position;
import com.aor.pman.viewer.game.GameWinViewer;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class GameWinViewerTest {

    @Test
    public void testDraw() throws IOException {
        // Create a mock GUI object
        GUI gui = mock(GUI.class);

        // Create a mock TextGraphics object
        TextGraphics textGraphics = mock(TextGraphics.class);
        when(gui.createTextGraphics()).thenReturn(textGraphics);

        // Create a new GameWinViewer object
        GameWinViewer viewer = new GameWinViewer(gui);

        // Call the draw method
        viewer.draw(gui);

        // Verify that the clear, drawBackground, drawText, and refresh methods of the GUI object were called
        verify(gui).clear();
        verify(gui).drawBackground(textGraphics, "#020721");
        verify(gui).drawText(new Position(10, 10), "!YOU WON!", "#020721", "#00FF00");
        verify(gui).drawText(new Position(9, 20), "PRESS ENTER", "#020721", "#FFFFFF");
        verify(gui).drawText(new Position(5, 21), "TO GO BACK TO MENU", "#020721", "#FFFFFF");
        verify(gui).refresh();
    }
}

