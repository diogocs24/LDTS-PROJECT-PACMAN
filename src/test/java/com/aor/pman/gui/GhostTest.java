package com.aor.pman.gui;

import com.aor.pman.model.game.Position;
import com.aor.pman.model.ghost.Ghost;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GhostTest {
    @Test
    public void testGhostPosition() {
        Ghost ghost = new Ghost(10, 20);
        Position position = ghost.getPosition();
        assertEquals(10, position.getX());
        assertEquals(20, position.getY());

        ghost.setPosition(new Position(30, 40));
        position = ghost.getPosition();
        assertEquals(30, position.getX());
        assertEquals(40, position.getY());
    }





}
