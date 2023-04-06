package com.aor.pman.model.game;

import com.aor.pman.gui.GUI;
import com.aor.pman.model.ghost.Ghost;
import com.aor.pman.model.item.Coin;
import com.aor.pman.model.item.PowerUp;
import com.aor.pman.model.wall.*;
import com.aor.pman.gui.FileReader;
import com.aor.pman.viewer.game.MapViewer;
import com.aor.pman.viewer.game.MusicPlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Map {

    private ArrayList<Wall> walls;
    private Ghost pinkyGhost;
    private Ghost inkyGhost;
    private Ghost clydeGhost;

    private Ghost blinkyGhost;
    private ArrayList<Coin> coins;
    private final GUI gui;
    private final Pacman pacman;
    private final int width, height;
    private final MapViewer mapViewer;
    private final FileReader file;


    private Integer score = 0;


    public Map(int width, int height, GUI gui) throws FileNotFoundException {
        pacman = new Pacman(14, 18);
        this.width = width;
        this.height = height;
        this.gui = gui;

        file = new FileReader("src/main/resources/maps/map.txt");
        mapViewer = new MapViewer(gui, this);

        createMap();

    }


    public void createMap(){
        ArrayList<Wall> walls = new ArrayList<>();
        ArrayList<Coin> coins = new ArrayList<>();
        ArrayList<PowerUp> powerUps = new ArrayList<>();

        List<String> lines = file.getMap();
        for(int row = 0; row < lines.size(); row++){
            String line = lines.get(row);
            char[] ch = new char[line.length()];
            for(int i = 0; i < line.length(); i++){
                ch[i] = line.charAt(i);
            }
            for(int col = 0; col < line.length(); col++){
                switch (ch[col]) {
                    case 'c' -> walls.add(new Wall(col, row));
                    case 'i' -> coins.add(new Coin(col, row));
                    case '-' -> powerUps.add(new PowerUp(col, row));
                }
            }
        }
        this.walls = walls;
        this.coins = coins;
        this.blinkyGhost = createBlinkyGhost();
        this.pinkyGhost = createPinkyGhost();
        this.inkyGhost = createInkyGhost();
        this.clydeGhost = createClydeGhost();
    }

    public boolean canPacmanMove(Position position) {

        for(Wall wall: walls) {
            if (position.equals(wall.getPosition())) {
                return false;
            }
        }
    return true;
    }



    public void movePacman(Position position){
        if(canPacmanMove(position)) {
            pacman.setPosition(position);
            collectCoins();
        }
    }


    public List<Wall> getWalls() {
        return walls;
    }

    public Ghost getPinkyGhost() {
        return pinkyGhost;
    }

    public Ghost getInkyGhost() {
        return inkyGhost;
    }

    public Ghost getClydeGhost() {
        return clydeGhost;
    }
    public Ghost getBlinkyGhost() {
        return blinkyGhost;
    }


    public Pacman getPacman() { return pacman;}

    private Ghost createBlinkyGhost() {
        return new Ghost(16, 11);
    }

    private Ghost createPinkyGhost(){
        return new Ghost(14, 11);
    }

    private Ghost createInkyGhost(){
        return new Ghost(12, 11);
    }

    private Ghost createClydeGhost(){
        return new Ghost(10, 11);
    }






    public Position moveGhost(Ghost ghost) {
        Random r = new Random();

        Position pRight = new Position(ghost.getPosition().getX() + r.nextInt(3) - 1,ghost.getPosition().getY());
        Position pLeft = new Position(ghost.getPosition().getX(), ghost.getPosition().getY() + r.nextInt(3) - 1);
        if(canGhostMove(pRight)) return pRight;
        if(canGhostMove(pLeft)) return pLeft;
        return ghost.getPosition();


    }

    public void moveGhosts(){
        pinkyGhost.setPosition(moveGhost(pinkyGhost));
        clydeGhost.setPosition(moveGhost(clydeGhost));
        inkyGhost.setPosition(moveGhost(inkyGhost));
        blinkyGhost.setPosition(moveGhost(blinkyGhost));


    }


    private void collectCoins() {
        for (Coin coin : coins)
            if (pacman.getPosition().equals(coin.getPosition())) {
                coins.remove(coin);
                MusicPlayer musicPlayer = new MusicPlayer("src/main/resources/music/Chomp.wav");
                musicPlayer.startMusic();
                setScore(score + 10);
                break;
            }
    }

    public boolean canGhostMove(Position position) {
        for(Wall wall: walls) {
            if (position.equals(wall.getPosition())) {
                return false;
            }

        }



        if(position.equals(pinkyGhost.getPosition())) {
            return false;
        }

        if(position.equals(inkyGhost.getPosition())) {
            return false;
        }

        return !position.equals(clydeGhost.getPosition());
    }
    public boolean checkGhostEatsPacman() {
        if(clydeGhost.getPosition().equals(pacman.getPosition())) return true;
        else if(blinkyGhost.getPosition().equals(pacman.getPosition())) return true;
        else if(inkyGhost.getPosition().equals(pacman.getPosition())) return true;
        else return pinkyGhost.getPosition().equals(pacman.getPosition());
    }


    public void draw() throws IOException {
        mapViewer.draw();
        gui.refresh();
    }


    public String getScore(){
        return Integer.toString(score);
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<Coin> getCoins() {
        return coins;
    }

    public Pacman getPlayer() {
        return pacman;
    }


    public boolean isInBounds(Position position){
        if(position.getY() < width && position.getX() < height) return true;
        return false;
    }
}
