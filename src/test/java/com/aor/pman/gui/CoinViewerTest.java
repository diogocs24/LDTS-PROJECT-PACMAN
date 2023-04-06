package com.aor.pman.gui;

import com.aor.pman.model.item.Coin;
import com.aor.pman.viewer.game.CoinViewer;
import org.junit.Test;

import java.io.IOException;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CoinViewerTest {

    @Test
    public void testDraw() throws IOException {
        // Create a new Coin object with position (1, 2)
        Coin coin = new Coin(1, 2);

        // Create a mock GUI object
        GUI gui = mock(GUI.class);

        // Create a new CoinViewer object
        CoinViewer coinViewer = new CoinViewer();

        // Invoke the draw method of the CoinViewer object
        coinViewer.draw(coin, gui);

        // Verify that the drawCoin method of the GUI object has been called with the correct arguments
        verify(gui).drawCoin(coin.getPosition(), "#FFFFFF");
    }
}

