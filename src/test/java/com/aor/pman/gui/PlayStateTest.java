package com.aor.pman.gui;

import com.aor.pman.Game;
import com.aor.pman.model.game.Map;
import com.aor.pman.state.PlayState;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class PlayStateTest {
    @Test
    public void testStart() throws IOException {
        // Create a mock Game object and GUI object
        Game game = mock(Game.class);
        GUI gui = mock(GUI.class);
        when(game.getGui()).thenReturn(gui);

        // Create a mock Map object and set it on the Game object
        Map map = mock(Map.class);
        when(game.getMap()).thenReturn(map);

        // Create a PlayState object using the mock Game object
        PlayState playState = new PlayState(game);

        // Call the start method on the PlayState object
        playState.start(gui);

        // Verify that the moveGhosts method was called on the Map object
        verify(map).moveGhosts();

        // Verify that the draw method was called on the Map object
        verify(map).draw();
    }

}
