package dev.clao;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public class BackgroundMusic {
    private final Music music;

    public BackgroundMusic(String filepath) {
        music = Gdx.audio.newMusic(Gdx.files.internal(filepath));
        music.setLooping(true);
        play();
    }
    public void play() {
        music.play();
    }

    public void stop() {
        music.stop();
    }

    public void dispose() {
        stop();
        music.dispose();
    }
}