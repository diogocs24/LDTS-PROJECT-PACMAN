package com.aor.pman.gui;

import com.aor.pman.model.game.Element;
import com.aor.pman.viewer.game.ElementViewer;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ElementViewerTest extends Element{

    public ElementViewerTest(int x, int y) {
        super(x, y);
    }

    @Test
    public void testDraw() throws IOException {
        // Create a mock GUI object
        GUI gui = mock(GUI.class);

        // Create a mock object of MyClass, which implements the ElementViewer interface
        ElementViewer<Element> viewer = mock(ElementViewer.class);

        // Create a new Element object with position (1, 2)
        Element element = new ElementViewerTest(1, 2);

        // Invoke the draw method of the viewer object
        viewer.draw(element, gui);

        // Verify that the draw method of the MyClass object has been called with the correct arguments
        verify(viewer).draw(element, gui);
    }
}
