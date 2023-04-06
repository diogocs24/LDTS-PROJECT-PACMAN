package com.aor.pman.gui;

import com.aor.pman.model.game.Pacman;
import com.aor.pman.viewer.game.PacmanViewer;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PacmanViewerTest {

    @Test
    public void testDraw() throws IOException {
        // Create a new Pacman object with position (1, 2)
        Pacman pacman = new Pacman(1, 2);

        // Create a mock GUI object
        GUI gui = mock(GUI.class);

        // Create a new PacmanViewer object
        PacmanViewer pacmanViewer = new PacmanViewer();

        // Invoke the draw method of the PacmanViewer object
        pacmanViewer.draw(pacman, gui);

        // Verify that the drawPacmanUp method of the GUI object has been called with the correct arguments
        verify(gui).drawPacmanUp(pacman.getPosition(), "#FFFF00");
    }

    @Test
    public void testDraw_stateR() throws IOException {
        // Create a new Pacman object with position (1, 2)
        Pacman pacman = new Pacman(1, 2);

        // Create a mock GUI object
        GUI gui = mock(GUI.class);

        // Create a new PacmanViewer object
        PacmanViewer pacmanViewer = new PacmanViewer();

        // Invoke the draw method of the PacmanViewer object
        pacmanViewer.draw(pacman, gui);

        // Verify that the drawPacmanDown method of the GUI object has been called with the correct arguments
        verify(gui).drawPacmanDown(pacman.getPosition(), "#FFFF00");
    }

    @Test
    public void testDraw_stateS() throws IOException {
        // Create a new Pacman object with position (1, 2)
        Pacman pacman = new Pacman(1, 2);

        // Create a mock GUI object
        GUI gui = mock(GUI.class);

        // Create a new PacmanViewer object
        PacmanViewer pacmanViewer = new PacmanViewer();

        // Invoke the draw method of the PacmanViewer object
        pacmanViewer.draw(pacman, gui);

        // Verify that the drawPacmanLeft method of the GUI object has been called with the correct arguments
        verify(gui).drawPacmanLeft(pacman.getPosition(), "#FFFF00");
    }

    @Test
    public void testDraw_stateE() throws IOException {
        // Create a new Pacman object with position (1, 2)
        Pacman pacman = new Pacman(1, 2);

        // Create a mock GUI object
        GUI gui = mock(GUI.class);

        // Create a new PacmanViewer object
        PacmanViewer pacmanViewer = new PacmanViewer();

        // Invoke the draw method of the PacmanViewer object
        pacmanViewer.draw(pacman, gui);

        // Verify that the drawPacmanRight method

    }
}