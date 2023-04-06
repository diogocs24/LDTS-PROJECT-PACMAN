package com.aor.pman.gui;

import com.aor.pman.model.game.Map;
import com.aor.pman.model.game.Position;
import com.aor.pman.viewer.game.MapViewer;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MapViewerTest {

    @Test
    public void testDraw() throws IOException {
        // Create a mock GUI object
        GUI gui = mock(GUI.class);

        // Create a mock Map object
        Map map = mock(Map.class);

        // Create a new MapViewer object
        MapViewer mapViewer = new MapViewer(gui, map);

        // Invoke the draw method of the MapViewer object
        mapViewer.draw();

        // Verify that the clear and drawBackground methods of the GUI object have been called
        verify(gui).clear();
        verify(gui).drawBackground(any(), eq("#000000"));

        // Verify that the drawElements method of the MapViewer object has been called with the correct arguments
        verify(mapViewer).drawElements(map.getWalls(), any());
        verify(mapViewer).drawElements(map.getCoins(), any());

        // Verify that the drawElement method of the MapViewer object has been called with the correct arguments
        verify(mapViewer).drawElement(map.getPinkyGhost(), any());
        verify(mapViewer).drawElement(map.getInkyGhost(), any());
        verify(mapViewer).drawElement(map.getClydeGhost(), any());
        verify(mapViewer).drawElement(map.getBlinkyGhost(), any());
        verify(mapViewer).drawElement(map.getPlayer(), any());

        // Verify that the drawText method of the GUI object has been called with the correct arguments
        verify(gui).drawText(new Position(17, 0), "SCORE", "#000000", "#FFFFFF");
        verify(gui).drawText(new Position(23, 0), map.getScore(), "#000000", "#FFFFFF");
        verify(gui).drawText(new Position(1, 27), "LIVES:", "#000000", "#FFFFFF");
        verify(gui).drawText(new Position(7, 27), any(), eq("#000000"), eq("#FF0000"));
    }
}
