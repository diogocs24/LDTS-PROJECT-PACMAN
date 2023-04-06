package com.aor.pman.gui;

import com.aor.pman.viewer.game.MusicPlayer;
import org.junit.Test;

import javax.sound.sampled.Clip;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class MusicPlayerTest {
    @Test
    public void testLoadMusic() {
        MusicPlayer player = new MusicPlayer("test_music.mp3");
        Clip musicClip = player.loadMusic("test_music.mp3");
        assertNotNull(musicClip);
    }

    @Test
    public void testStartMusic() {
        MusicPlayer player = new MusicPlayer("test_music.mp3");
        player.startMusic();
        assertTrue(player.backgroundMusic.isRunning());
    }
}

