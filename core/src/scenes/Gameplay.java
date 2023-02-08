package scenes;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.ScreenUtils;

import dev.clao.GameMain;

public class Gameplay implements Screen {
    private GameMain game;

    public Gameplay(GameMain game) {
        this.game = game;
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 1, 1);
        game.getBatch().begin();

        game.getBatch().end();
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

    @Override
    public void dispose() {

    }
}
