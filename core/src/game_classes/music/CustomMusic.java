package game_classes.music;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public class CustomMusic {
    private final Music music;

    public CustomMusic(String filepath) {
        music = Gdx.audio.newMusic(Gdx.files.internal(filepath));
        music.setLooping(true);
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

    public boolean isPlaying() {
        return music.isPlaying();
    }
}