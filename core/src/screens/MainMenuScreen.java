package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import dev.clao.GameMain;
import helpers.GameInfo;
import objects.main_menu.CustomButton;

public class MainMenuScreen implements Screen {
    private final GameMain game;
    private final SpriteBatch spriteBatch;
    private final CustomButton playButton, settingsButton,  creditsButton, exitButton;

    public MainMenuScreen(GameMain game) {
        this.game = game;
        this.spriteBatch = game.getBatch();

        playButton = createButton(GameInfo.PLAY_BUTTON_FILENAME, GameInfo.PLAY_BUTTON_POSITION);
        settingsButton = createButton(GameInfo.SETTINGS_BUTTON_FILENAME, GameInfo.SETTINGS_BUTTON_POSITION);
        creditsButton = createButton(GameInfo.CREDITS_BUTTON_FILENAME, GameInfo.CREDITS_BUTTON_POSITION);
        exitButton = createButton(GameInfo.EXIT_BUTTON_FILENAME, GameInfo.EXIT_BUTTON_POSITION);
    }

    private CustomButton createButton(String filename, float percentageOfScreenEight) {
        CustomButton button =  new CustomButton(filename, spriteBatch);
        button.updatePosition(
                GameInfo.WIDTH/2f -  button.getWidth()/2,
                (GameInfo.HEIGHT -  button.getHeight())/GameInfo.NUMBER_OF_SCREEN_DIVISIONS*percentageOfScreenEight);

        return button;
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        spriteBatch.begin();

        playButton.draw();
        settingsButton.draw();
        creditsButton.draw();
        exitButton.draw();

        spriteBatch.end();

        checkIfPressed();
    }

    public void checkIfPressed() {
        if (Gdx.input.isTouched()) {
            float mouseX = Gdx.input.getX();
            float mouseY = Gdx.graphics.getHeight() - Gdx.input.getY();

            if (playButton.getBoundingRectangle().contains(mouseX, mouseY)) {
                game.gotToPlay();
            }

            if (settingsButton.getBoundingRectangle().contains(mouseX, mouseY)) {
                game.goToSettings();
            }

            if (creditsButton.getBoundingRectangle().contains(mouseX, mouseY)) {
                game.goToCredits();
            }

            if (exitButton.getBoundingRectangle().contains(mouseX, mouseY)) {
                game.exit();
            }
        }

    }

    @Override
    public void dispose() {
        playButton.dispose();
        settingsButton.dispose();
        creditsButton.dispose();
        exitButton.dispose();
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
