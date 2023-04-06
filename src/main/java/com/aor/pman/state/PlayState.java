package com.aor.pman.state;
import com.aor.pman.Game;
import com.aor.pman.gui.GUI;
import com.aor.pman.model.game.Map;
import com.aor.pman.model.menu.Menu;
import com.aor.pman.viewer.game.MapViewer;
import com.aor.pman.viewer.game.MusicPlayer;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.io.IOException;

public class PlayState implements State{
    private Game game;
    private GUI gui;
    private Map map;
    private Menu menu;
    private boolean flag = true;
    private State state;
    private MapViewer mapViewer;

    public PlayState(Game game) throws IOException {
        this.gui = game.getGui();
        mapViewer = new MapViewer(gui, map);
        this.game = game;
        this.map = game.getMap();
        this.menu = game.getMenu();
        MusicPlayer musicPlayer = new MusicPlayer("src/main/resources/music/Intro.wav");
        musicPlayer.startMusic();

    }

    @Override
    public void start(GUI gui) throws IOException {
        game.getMap().moveGhosts();

        if(game.getMap().getCoins().size() == 0){
            game.setState(new GameWonState(game));
        }

        if(game.getMap().checkGhostEatsPacman()){
            if(game.getMap().getPacman().getLives() == 1){
                game.setState(new GameOverState(game));
            }
            else{
                game.getMap().getPacman().decrementLives();
                game.getMap().getPacman().setPositionDefault();
                MusicPlayer musicPlayer = new MusicPlayer("src/main/resources/music/Pacman-death.wav");
                musicPlayer.startMusic();
            }

        }
        map.draw();
    }

    @Override
    public void processInput(KeyStroke keystroke) throws IOException{
        if(keystroke.getKeyType() == KeyType.Escape)
            game.setState(new PauseState(game));

        game.processKey(keystroke);
    }


}
