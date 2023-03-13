package game_classes.screen.blueprint;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;

import dev.clao.GameMain;
import game_classes.screen.uicomponents.BackgroundImage;

public class UIScreen extends SimpleScreen {
    private final Stage stage;

    private BackgroundImage backgroundImage;


    public UIScreen(GameMain game) {
        super(game);

        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {
        super.show();

        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();

        backgroundImage = new BackgroundImage(getConstants().BACKGROUND_IMAGE_FILEPATH, screenWidth, screenHeight, getBatch());
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        getBatch().begin();
        backgroundImage.draw();
        getBatch().end();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);

        backgroundImage.resize(width, height);
    }

    @Override
    public void dispose() {
        super.dispose();

        stage.dispose();
        backgroundImage.dispose();
    }

    public Stage getStage() {
        return stage;
    }

}
