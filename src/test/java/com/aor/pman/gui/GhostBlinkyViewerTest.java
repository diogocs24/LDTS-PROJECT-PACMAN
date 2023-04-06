package com.aor.pman.gui;

import com.aor.pman.model.ghost.Ghost;
import com.aor.pman.viewer.ghost.GhostBlinkyViewer;
import org.junit.Test;

public class GhostBlinkyViewerTest {
    @Test(expected = IllegalArgumentException.class)
    public void testDrawWithNullGUI() {
        // create a GhostBlinkyViewer and a Ghost
        GhostBlinkyViewer viewer = new GhostBlinkyViewer();
        Ghost ghost = new Ghost(5, 5);

        // call the draw method with a null GUI
        viewer.draw(ghost, null);
    }

}
