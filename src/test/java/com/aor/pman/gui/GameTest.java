package com.aor.pman.gui;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import com.aor.pman.Game;
import com.aor.pman.model.game.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;

class GameTest {
    private Game game;
    private GUI gui;
    private Map map;

    @BeforeEach
    public void setUp() throws IOException, FontFormatException {
        game = Game.getInstance();
        gui = mock(GUI.class);
        map = mock(Map.class);
    }

    @Test
    void testGetWidth() {
        assertEquals(28, game.getWidth());
    }

    @Test
    void testSetAndGetHeight() {
        game.setHeight(10);
        assertEquals(10, game.getHeight());
    }

    @Test
    void testGetGui() {
        assertNotNull(game.getGui());
    }

    @Test
    void testGetMap() {
        assertNotNull(game.getMap());
    }

    @Test
    void testGetMenu() {
        assertNotNull(game.getMenu());
    }

    @Test
    void testSetMap() {
        game.setMap(map);
        assertEquals(map, game.getMap());
    }
}

