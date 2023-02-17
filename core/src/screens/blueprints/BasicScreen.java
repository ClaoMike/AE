package screens.blueprints;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import dev.clao.GameMain;

public class BasicScreen implements Screen, BasicScreenMethods {
    protected final GameMain game;
    protected final SpriteBatch spriteBatch;

    public BasicScreen(GameMain game) {
        this.game = game;
        this.spriteBatch = game.getBatch();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        renderBeforDrawing();
        spriteBatch.begin();
        renderWhileDrawing();
        spriteBatch.end();
        renderAfterDrawing();
    }

    @Override
    public void renderBeforDrawing() {

    }

    @Override
    public void renderWhileDrawing() {

    }

    @Override
    public void renderAfterDrawing() {

    }

    @Override
    public void dispose() {
        disposeItems();
    }

    @Override
    public void disposeItems() {

    }

    @Override
    public void show() {

    }

    @Override
    public void resize(int width, int height) {

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
}
