package game_classes.screen.blueprint;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import dev.clao.GameMain;
import game_classes.Constants;
import game_classes.screen.uicomponents.FontGenerator;

public class SimpleScreen implements Screen {
    protected final GameMain game;
    protected OrthographicCamera mainCamera;
    protected BitmapFont font;


    public SimpleScreen(GameMain game) {
        this.game = game;
        font = FontGenerator.generateBitmap(getConstants().FONT_FILEPATH, getConstants().FONT_DEFAULT_SIZE, Color.RED);
    }

    @Override
    public void show() {
        mainCamera = new OrthographicCamera();
        mainCamera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        mainCamera.position.set(mainCamera.viewportWidth / 2f, mainCamera.viewportHeight / 2f, 0);
        mainCamera.update();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        getBatch().setProjectionMatrix(mainCamera.combined);
    }

    @Override
    public void resize(int width, int height) {
        mainCamera.viewportWidth = width;
        mainCamera.viewportHeight = height;
        mainCamera.update();
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
    }

    public Constants getConstants() {
        return game.getConstants();
    }

    public SpriteBatch getBatch() {
        return game.getBatch();
    }

}
