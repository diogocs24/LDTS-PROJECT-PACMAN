package com.aor.pman.gui;

import com.aor.pman.model.game.Position;
import com.aor.pman.model.ghost.Ghost;
import com.aor.pman.viewer.ghost.GhostClydeViewer;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class GhostClydeViewerTest {

    @Test
    public void testDraw() {
        // Create a mock Ghost object
        Ghost ghost = mock(Ghost.class);
        when(ghost.getPosition()).thenReturn(new Position(5, 10));

        // Create a mock GUI object
        GUI gui = mock(GUI.class);

        // Create a new GhostClydeViewer instance
        GhostClydeViewer viewer = new GhostClydeViewer();

        // Call the draw method
        viewer.draw(ghost, gui);

        // Verify that the GUI's drawGhosts method was called with the correct arguments
        verify(gui).drawGhosts(new Position(5, 10), "#FFA500");
    }
}
