package com.aor.pman.state;

import com.aor.pman.gui.GUI;
import com.googlecode.lanterna.input.KeyStroke;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public interface State {
    void start(GUI gui) throws IOException;
    void processInput(KeyStroke keystroke) throws IOException, URISyntaxException, FontFormatException;
}
