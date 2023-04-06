package com.aor.pman.gui;

import com.aor.pman.model.game.Pacman;
import com.aor.pman.model.game.Position;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

public class LanternaGUI implements GUI {
    private final TerminalScreen screen;
    private final int width;
    private final int height;
    private boolean flag = true;



    public LanternaGUI(int width, int height) throws IOException, FontFormatException {
        this.height = height;
        this.width = width;
        AWTTerminalFontConfiguration fontConfiguration = loadPacmanFont();
        Terminal terminal = createTerminal(width, height, fontConfiguration);
        this.screen = createScreen(terminal);
    }

    public Terminal createTerminal(int width, int height, AWTTerminalFontConfiguration fontConfig) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width, height);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);

        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
        Terminal terminal = terminalFactory.createTerminal();
        ((AWTTerminalFrame) terminal).setTitle("PACMAN");
        ((AWTTerminalFrame) terminal).setIconImage(ImageIO.read(getClass().getClassLoader().getResource("pacman_sorridente.png")));
        ((AWTTerminalFrame) terminal).addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                e.getWindow().dispose();
            }
        });
        return terminal;
    }

    public TerminalScreen getScreen() {
        return screen;
    }

    public TerminalScreen createScreen(Terminal terminal) throws IOException {
        final TerminalScreen terminalScreen;
        terminalScreen = new TerminalScreen(terminal);

        terminalScreen.setCursorPosition(null);
        terminalScreen.startScreen();
        terminalScreen.doResizeIfNecessary();
        return terminalScreen;
    }


    public AWTTerminalFontConfiguration loadPacmanFont() throws FontFormatException, IOException {
        File fontFile = new File("src/main/resources/fonts/pacmanFINALMENTE.ttf");
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 25);
        return AWTTerminalFontConfiguration.newInstance(loadedFont);
    }


    public TextGraphics createTextGraphics() {
        return screen.newTextGraphics();
    }


    public void clear() {
        screen.clear();
    }

    public void refresh() throws IOException {
        screen.refresh();
    }

    public void close() throws IOException {
        screen.close();
    }

    void drawElement(String color, int posX, int posY, String design) {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setForegroundColor(TextColor.Factory.fromString(color));
        graphics.putString(new TerminalPosition(posX, posY), design);
        graphics.setBackgroundColor(TextColor.Factory.fromString(null));
    }


    public void drawBackground(TextGraphics textGraphics, String color) {
        textGraphics.setBackgroundColor(TextColor.Factory.fromString(color));
        textGraphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(this.width, this.height), ' ');
        textGraphics.setBackgroundColor(TextColor.ANSI.BLACK);
        textGraphics.setForegroundColor(TextColor.ANSI.BLACK);
    }





    @Override
    public void drawGhosts(Position position, String color) {
        drawElement(color, position.getX(), position.getY(), "%");
    }

    @Override
    public void drawPacmanUp(Position position, String color) {
        drawElement(color, position.getX(), position.getY(), "q");
    }
    @Override
    public void drawPacmanDown(Position position, String color) {
        drawElement(color, position.getX(), position.getY(), "r");
    }
    @Override
    public void drawPacmanLeft(Position position, String color) {
        drawElement(color, position.getX(), position.getY(), "s");
    }
    @Override
    public void drawPacmanRight(Position position, String color) {
        drawElement(color, position.getX(), position.getY(), "e");
    }

    @Override
    public void drawWall(Position position, String color) {
        drawElement(color, position.getX(), position.getY(), "c");
    }

    @Override
    public void drawCoin(Position position, String color) {
        drawElement(color, position.getX(), position.getY(), "i");
    }

    @Override
    public void drawText(Position position, String text, String textColor, String backgroundColor) {
        TextGraphics textGraphics = screen.newTextGraphics();
        textGraphics.setBackgroundColor(TextColor.Factory.fromString(textColor));
        textGraphics.setForegroundColor(TextColor.Factory.fromString(backgroundColor));
        textGraphics.putString(position.getX(), position.getY(), text);
    }


    @Override
    public void drawPointer(Position position, String pointerColor) {
        if(flag == true){
            drawText(position, "%", pointerColor, "#FFC0CB");
            flag = false;
        }
        else{
            drawText(position, "%", pointerColor, "#00FFFF");
            flag = true;
        }
    }
}