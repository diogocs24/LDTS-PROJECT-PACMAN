package com.aor.pman.gui;

import com.aor.pman.model.game.Position;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GUITest {
    @Test
    public void testDrawPacmanUp() throws IOException {
        // Create a mock implementation of the Position interface
        Position mockPosition = mock(Position.class);

        // Create a mock implementation of the GUI interface
        GUI mockGUI = mock(GUI.class);

        // Call the drawPacmanUp method with the mock position and a color
        mockGUI.drawPacmanUp(mockPosition, "yellow");

        // Verify that the drawPacmanUp method was called with the correct arguments
        verify(mockGUI).drawPacmanUp(mockPosition, "yellow");
    }

}
