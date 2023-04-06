package com.aor.pman.gui;

import com.aor.pman.model.wall.Wall;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class WallTest {

    @Test
    public void testEquals() {
        // Create two new Wall objects with the same position
        Wall wall1 = new Wall(1, 2);
        Wall wall2 = new Wall(1, 2);

        // Verify that the two Wall objects are equal
        assertEquals(wall1, wall2);

        // Create a new Wall object with a different position
        Wall wall3 = new Wall(3, 4);

        // Verify that the two Wall objects are not equal
        assertNotEquals(wall1, wall3);
    }
}
