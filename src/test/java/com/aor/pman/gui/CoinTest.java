package com.aor.pman.gui;

import com.aor.pman.model.game.Position;
import com.aor.pman.model.item.Coin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoinTest {
    @Test
    public void testCoinPosition() {
        Coin coin = new Coin(10, 20);
        Position position = coin.getPosition();
        assertEquals(10, position.getX());
        assertEquals(20, position.getY());

        coin.setPosition(new Position(30, 40));
        position = coin.getPosition();
        assertEquals(30, position.getX());
        assertEquals(40, position.getY());
    }
}
