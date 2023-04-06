package com.aor.pman.gui;

import com.aor.pman.model.game.Map;
import com.aor.pman.model.game.Pacman;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerMoveTest {
    @Test
    public void MovePlayerTest() throws FileNotFoundException {
        Map map = new Map(7,7, null);
        Pacman player = new Pacman(4, 4);
        map.movePacman(player.moveUp());
        assertEquals(false,map.canPacmanMove(player.getPosition()));
    }

    @Test
    public void PlayerMoveUpTest(){
        Pacman player = new Pacman(5,5);
        assertEquals(4,player.moveUp().getY());
    }

    @Test
    public void PlayerMoveLeftTest(){
        Pacman player = new Pacman(5,5);
        assertEquals(4, player.moveLeft().getX());
    }

    @Test
    public void PlayerMoveDownTest(){
        Pacman player = new Pacman(5,5);
        assertEquals(6, player.moveDown().getY());
    }

    @Test
    public void PlayerMoveRightTest(){
        Pacman player = new Pacman(5,5);
        assertEquals(6, player.moveRight().getX());
    }


}