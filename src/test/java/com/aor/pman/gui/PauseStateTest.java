package com.aor.pman.gui;

import com.aor.pman.Game;
import com.aor.pman.model.game.Map;
import com.aor.pman.model.menu.Menu;
import com.aor.pman.state.MenuState;
import com.aor.pman.state.PauseState;
import com.aor.pman.state.PlayState;
import com.aor.pman.viewer.game.PauseViewer;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class PauseStateTest {
    // mock objects for dependencies
    Game game = mock(Game.class);
    GUI gui = mock(GUI.class);
    PauseViewer pauseViewer = mock(PauseViewer.class);

    @Test
    public void testStart() throws IOException {
        // create instance of PauseState
        PauseState state = new PauseState(game);

        // call start method
        state.start(gui);

        // verify that pauseViewer.draw was called with the correct arguments
        verify(pauseViewer).draw(gui);
    }

    @Test
    public void testProcessInput_escape() throws IOException {
        // create instance of PauseState
        PauseState state = new PauseState(game);

        // create mock KeyStroke with key type Escape
        KeyStroke keystroke = mock(KeyStroke.class);
        when(keystroke.getKeyType()).thenReturn(KeyType.Escape);

        // call processInput method
        state.processInput(keystroke);

        // verify that game.setState was called with the correct arguments
        verify(game).setState(new PlayState(game));
    }

    @Test
    public void testProcessInput_enter() throws IOException {
        // create instance of PauseState
        PauseState state = new PauseState(game);

        // create mock KeyStroke with key type Enter
        KeyStroke keystroke = mock(KeyStroke.class);
        when(keystroke.getKeyType()).thenReturn(KeyType.Enter);

        // mock game.getWidth and game.getHeight methods
        when(game.getWidth()).thenReturn(10);
        when(game.getHeight()).thenReturn(20);

        // mock game.getMenu method
        Menu menu = mock(Menu.class);
        when(game.getMenu()).thenReturn(menu);

        // call processInput method
        state.processInput(keystroke);

        // verify that game.setMap and game.setState were called with the correct arguments
        verify(game).setMap(new Map(10, 20, gui));
        verify(game).setState(new MenuState(game, gui, menu));
    }

    @Test
    public void testProcessInput_character() throws IOException {
        // create instance of PauseState
        PauseState state = new PauseState(game);

        // create mock KeyStroke with key type Character
        KeyStroke keystroke = mock(KeyStroke.class);
        when(keystroke.getKeyType()).thenReturn(KeyType.Character);

        // mock game.getWidth and game.getHeight methods
        when(game.getWidth()).thenReturn(10);
        when(game.getHeight()).thenReturn(20);

        // mock game.getMenu method
        Menu menu = mock(Menu.class);
        when(game.getMenu()).thenReturn(menu);

        // call processInput method
        state.processInput(keystroke);

        //
    }
}