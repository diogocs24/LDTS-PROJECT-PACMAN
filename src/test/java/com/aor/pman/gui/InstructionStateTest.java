package com.aor.pman.gui;

import com.aor.pman.Game;
import com.aor.pman.model.menu.Menu;
import com.aor.pman.state.InstructionState;
import com.aor.pman.state.MenuState;
import com.aor.pman.viewer.game.InstructionViewer;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import org.junit.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.mockito.Mockito.*;

public class InstructionStateTest {

    @Test
    public void testStart() throws IOException {
        // Create a mock Game object
        Game game = mock(Game.class);

        // Create a mock GUI object
        GUI gui = mock(GUI.class);
        when(game.getGui()).thenReturn(gui);

        // Create a mock InstructionViewer object
        InstructionViewer instructionsViewer = mock(InstructionViewer.class);

        // Create a mock Menu object
        Menu menu = mock(Menu.class);

        // Create a new InstructionState instance
        InstructionState state = new InstructionState(game, menu);

        // Call the start method
        state.start(gui);

        // Verify that the InstructionViewer's draw method was called
        verify(instructionsViewer).draw(gui);
    }

    @Test
    public void testProcessInputEscape() throws IOException, URISyntaxException, FontFormatException {
        // Create a mock Game object
        Game game = mock(Game.class);

        // Create a mock GUI object
        GUI gui = mock(GUI.class);
        when(game.getGui()).thenReturn(gui);

        // Create a mock Menu object
        Menu menu = mock(Menu.class);

        // Create a new InstructionState instance
        InstructionState state = new InstructionState(game, menu);

        // Create a KeyStroke object representing the Escape key
        KeyStroke keystroke = mock(KeyStroke.class);
        when(keystroke.getKeyType()).thenReturn(KeyType.Escape);

        // Call the processInput method
        state.processInput(keystroke);

        // Verify that the setState method of the Game object was called with the correct arguments
        verify(game).setState(new MenuState(game, gui, menu));
    }
}
