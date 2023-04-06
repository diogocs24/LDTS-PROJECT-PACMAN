package com.aor.pman.gui;

import com.aor.pman.model.game.Position;
import com.aor.pman.viewer.game.InstructionViewer;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class InstructionViewerTest {
    @Test
    public void testDraw() throws IOException {
        // Create a mock GUI object
        GUI gui = mock(GUI.class);

        // Create an InstructionViewer object using the mock GUI object
        InstructionViewer instructionViewer = new InstructionViewer(gui);

        // Call the draw method on the InstructionViewer object
        instructionViewer.draw(gui);

        // Verify that the clear method was called on the GUI object
        verify(gui).clear();

        // Verify that the drawBackground method was called with the correct arguments on the GUI object
        verify(gui).drawBackground(gui.createTextGraphics(), "#020721");

        // Verify that the drawText method was called with the correct arguments on the GUI object
        verify(gui).drawText(new Position(10, 4), "RULES", "#020721", "#FFFF00");
        verify(gui).drawText(new Position(1, 7), "%", "#020721", "#FF0000");
        verify(gui).drawText(new Position(1, 8), "%", "#020721", "#FFA500");
        verify(gui).drawText(new Position(1, 9), "%", "#020721", "#00FFFF");
        verify(gui).drawText(new Position(3, 7), "COLLECT ALL COINS TO WIN",  "#020721", "#FFFFFF");
        verify(gui).drawText(new Position(3, 8), "AVOIDING THE GHOSTS", "#020721", "#FFFFFF");
        verify(gui).drawText(new Position(3, 9), "THAT WILL TRY TO EAT YOU", "#020721", "#FFFFFF");
        verify(gui).drawText(new Position(1, 12), "%", "#020721", "#FFC0CB");
        verify(gui).drawText(new Position(3, 12), "USE ARROWS TO MOVE", "#020721", "#FFFFFF");
        verify(gui).drawText(new Position(1, 20), "PRESS ESC TO RETURN","#020721", "#FFFFFF" );

        // Verify that the refresh method was called on the GUI object
        verify(gui).refresh();
    }

}
