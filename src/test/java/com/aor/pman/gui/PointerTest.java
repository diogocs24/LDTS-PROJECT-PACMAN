package com.aor.pman.gui;

import com.aor.pman.model.game.Position;
import com.aor.pman.model.menu.Pointer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PointerTest {

        @Test
        public void testGetPosition() {
            // Create a new Pointer object with x = 1 and y = 2
            Pointer pointer = new Pointer(1, 2);

            // Get the position of the pointer
            Position position = pointer.getPosition();

            // Verify that the position is correct
            assertEquals(1, position.getX());
            assertEquals(2, position.getY());
        }

        @Test
        public void testSetPosition() {
            // Create a new Pointer object with x = 1 and y = 2
            Pointer pointer = new Pointer(1, 2);

            // Create a new position with x = 3 and y = 4
            Position newPosition = new Position(3, 4);

            // Set the position of the pointer to the new position
            pointer.setPosition(newPosition);

            // Get the position of the pointer
            Position position = pointer.getPosition();

            // Verify that the position has been updated
            assertEquals(3, position.getX());
            assertEquals(4, position.getY());
        }

}