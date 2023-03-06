package refactor.screen.blueprint;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;

import dev.clao.GameMain;

public class UIScreen extends SimpleScreen {
    private final Stage stage;

    public UIScreen(GameMain game) {
        super(game);

        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        getBatch().begin();
        stage.draw();
        getBatch().end();
    }

    @Override
    public void dispose() {
        super.dispose();
        stage.dispose();
    }

    public Stage getStage() {
        return stage;
    }

}
