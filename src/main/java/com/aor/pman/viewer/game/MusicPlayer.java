package com.aor.pman.viewer.game;

import javax.sound.sampled.*;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.File;

public class MusicPlayer {
    public Clip backgroundMusic;

    public MusicPlayer(String file){
        this.backgroundMusic = loadMusic(file);
    }

    public Clip loadMusic(String file) throws NullPointerException{
        try{
            File musicFile = new File(file);
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicFile);
            Clip musicClip = AudioSystem.getClip();
            musicClip.open(audioInput);
            FloatControl gainControl = (FloatControl) musicClip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-25.0f);
            return musicClip;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void startMusic() {
        backgroundMusic.setMicrosecondPosition(0);
        backgroundMusic.start();
    }
}


