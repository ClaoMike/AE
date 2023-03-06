package refactor.screen.blueprint;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import dev.clao.GameMain;

public class SimpleScreen implements Screen {
    class BackgroundImage {
        private SpriteBatch batch;
        private Texture texture;
        private Sprite sprite;

        public BackgroundImage(String filepath, float width, float height, SpriteBatch batch) {
            this.batch = batch;

            texture = new Texture(Gdx.files.internal(filepath));
            sprite = new Sprite(texture);
            sprite.setSize(width, height);
        }

        public void draw() {
            sprite.draw(batch);
        }

        public void resize(int width, int height) {
            sprite.setSize(width, height);
        }

        public void dispose() {
            texture.dispose();
        }
    }

    class BackgroundMusic {
        private Music music;

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

    private final GameMain game;
    private final SpriteBatch batch;
    private Viewport viewport;
    private BackgroundImage backgroundImage;
    private BackgroundMusic backgroundMusic;

    public SimpleScreen(GameMain game) {
        this.game = game;
        this.batch = game.getBatch();
    }

    @Override
    public void show() {
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();

        backgroundImage = new BackgroundImage("refactor/images/background.png", screenWidth, screenHeight, batch);
        backgroundMusic = new BackgroundMusic("refactor/music/background.mp3");

        viewport = new StretchViewport(screenWidth, screenHeight);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(viewport.getCamera().combined);

        batch.begin();
        backgroundImage.draw();
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
        backgroundImage.resize(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        backgroundImage.dispose();
        backgroundMusic.dispose();
    }
}
