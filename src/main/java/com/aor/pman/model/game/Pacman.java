package com.aor.pman.model.game;

public class Pacman extends Element {

    private int lives = 3;

    private String pacmanState = "q";

    public Pacman(int x, int y) {
        super(x, y);
    }

    public Position moveUp() {pacmanState = "q"; return new Position(position.getX(),position.getY()-1);}
    public Position moveDown() {pacmanState = "r";return new Position(position.getX(),position.getY()+1);}
    public Position moveRight() {pacmanState = "e";return new Position(position.getX()+1,position.getY());}
    public Position moveLeft() {pacmanState = "s";return new Position(position.getX()-1,position.getY());}


    public int getLives(){return lives;}

    public String getPacmanState(){return pacmanState;}

    public void setPositionDefault(){setPosition(new Position(14,18));}

    public void decrementLives(){
        this.lives--;
    }

}
