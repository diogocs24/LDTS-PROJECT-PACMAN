package com.aor.pman.gui;

import com.aor.pman.model.game.Pacman;
import com.aor.pman.model.game.Position;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PacmanTest {

    @Test
    public void testMoveUp() {
        Pacman pacman = new Pacman(14, 18);
        Position expected = new Position(14, 17);
        assertEquals(expected, pacman.moveUp());
    }

    @Test
    public void testMoveDown() {
        Pacman pacman = new Pacman(14, 18);
        Position expected = new Position(14, 19);
        assertEquals(expected, pacman.moveDown());
    }

    @Test
    public void testMoveRight() {
        Pacman pacman = new Pacman(14, 18);
        Position expected = new Position(15, 18);
        assertEquals(expected, pacman.moveRight());
    }

    @Test
    public void testMoveLeft() {
        Pacman pacman = new Pacman(14, 18);
        Position expected = new Position(13, 18);
        assertEquals(expected, pacman.moveLeft());
    }

    @Test
    public void testGetLives() {
        Pacman pacman = new Pacman(14, 18);
        assertEquals(3, pacman.getLives());
    }

    @Test
    public void testGetPacmanState() {
        Pacman pacman = new Pacman(14, 18);
        assertEquals("q", pacman.getPacmanState());
    }

    @Test
    public void testSetPositionDefault() {
        Pacman pacman = new Pacman(14, 18);
        pacman.setPositionDefault();
        Position expected = new Position(14, 18);
        assertEquals(expected, pacman.getPosition());
    }

    @Test
    public void testDecrementLives() {
        Pacman pacman = new Pacman(14, 18);
        pacman.decrementLives();
        assertEquals(2, pacman.getLives());
    }
}



