package com.aor.pman.gui;

import com.aor.pman.model.game.Position;
import org.junit.Test;

import static org.junit.Assert.*;

public class PositionTest {

    @Test
    public void testGetX() {
        Position position = new Position(14, 18);
        assertEquals(14, position.getX());
    }

    @Test
    public void testGetY() {
        Position position = new Position(14, 18);
        assertEquals(18, position.getY());
    }

    @Test
    public void testEqualsPositive() {
        Position position1 = new Position(14, 18);
        Position position2 = new Position(14, 18);
        assertTrue(position1.equals(position2));
    }

    @Test
    public void testEqualsNegative() {
        Position position1 = new Position(14, 18);
        Position position2 = new Position(15, 18);
        assertFalse(position1.equals(position2));
    }

    @Test
    public void testEqualsNull() {
        Position position = new Position(14, 18);
        assertFalse(position.equals(null));
    }

    @Test
    public void testEqualsDifferentClass() {
        Position position = new Position(14, 18);
        String str = "not a position";
        assertFalse(position.equals(str));
    }
}
