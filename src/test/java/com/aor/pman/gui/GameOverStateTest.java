package com.aor.pman.gui;

import com.aor.pman.Game;
import com.aor.pman.model.game.Map;
import com.aor.pman.model.menu.Menu;
import com.aor.pman.state.GameOverState;
import com.aor.pman.state.MenuState;
import com.aor.pman.viewer.game.GameOverViewer;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class GameOverStateTest {
    private Game game;
    private GUI gui;
    private Menu menu;
    private GameOverState state;
    private GameOverViewer gameOverViewer;

    @Before
    public void setUp() throws Exception {
        game = Mockito.mock(Game.class);
        gui = Mockito.mock(GUI.class);
        menu = Mockito.mock(Menu.class);
        gameOverViewer = Mockito.mock(GameOverViewer.class);

        Mockito.when(game.getGui()).thenReturn(gui);
        Mockito.when(game.getMenu()).thenReturn(menu);

        state = new GameOverState(game);
    }

    @Test
    public void testStart() throws IOException {
        state.start(gui);
        Mockito.verify(gameOverViewer).draw(gui);
    }

    @Test
    public void testProcessInput_enter() throws IOException, URISyntaxException, FontFormatException {
        state.processInput(new KeyStroke(KeyType.Enter));
        Mockito.verify(game).setMap(Mockito.any(Map.class));
        Mockito.verify(game).setState(Mockito.any(MenuState.class));
    }

    @Test
    public void testProcessInput_escape() throws IOException, URISyntaxException, FontFormatException {
        state.processInput(new KeyStroke(KeyType.Escape));
        Mockito.verify(gui).close();
    }
}
