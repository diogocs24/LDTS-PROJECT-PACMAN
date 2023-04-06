package com.aor.pman.gui;


import com.aor.pman.model.game.Map;
import com.aor.pman.model.game.Pacman;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PacmanMoveTest {
    @Test
    public void MovePlayerTest() throws FileNotFoundException {
        Map map = new Map(7,7, null);
        Pacman pacman = new Pacman(4, 4);
        map.movePacman(pacman.moveUp());
        assertEquals(false,map.canPacmanMove(pacman.getPosition()));
    }

    @Test
    public void PlayerMoveUpTest(){
        Pacman pacman = new Pacman(5,5);
        assertEquals(4, pacman.moveUp().getY());
    }

    @Test
    public void PlayerMoveLeftTest(){
        Pacman pacman = new Pacman(5,5);
        assertEquals(4, pacman.moveLeft().getX());
    }

    @Test
    public void PlayerMoveDownTest(){
        Pacman pacman = new Pacman(5,5);
        assertEquals(6, pacman.moveDown().getY());
    }

    @Test
    public void PlayerMoveRightTest(){
        Pacman pacman = new Pacman(5,5);
        assertEquals(6, pacman.moveRight().getX());
    }


}
