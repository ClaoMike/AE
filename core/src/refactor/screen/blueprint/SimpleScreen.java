package refactor.screen.blueprint;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import dev.clao.GameMain;
import refactor.Constants;

public class SimpleScreen implements Screen {
    private final GameMain game;
    private Viewport viewport;
    private BackgroundImage backgroundImage;
    private BackgroundMusic backgroundMusic;
    private CustomFont font;

    public SimpleScreen(GameMain game) {
        this.game = game;
    }

    @Override
    public void show() {
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();

        backgroundImage = new BackgroundImage(getConstants().BACKGROUND_IMAGE_FILEPATH, screenWidth, screenHeight, getBatch());
        backgroundMusic = new BackgroundMusic(getConstants().BACKGROUND_MUSIC_FILEPATH);
        font = new CustomFont(getConstants().FONT_FILEPATH, getConstants().FONT_DEFAULT_SIZE, Color.RED, getBatch());

        viewport = new StretchViewport(screenWidth, screenHeight);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        getBatch().setProjectionMatrix(viewport.getCamera().combined);

        getBatch().begin();
        backgroundImage.draw();
        getBatch().end();
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

    public Constants getConstants() {
        return game.getConstants();
    }

    public SpriteBatch getBatch() {
        return game.getBatch();
    }

    public CustomFont getFont() {
        return font;
    }
}
