package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import dev.clao.GameMain;
import helpers.GameInfo;

public class MainMenuScreen implements Screen {
    private final GameMain game;
    private final SpriteBatch batch;
    private final CustomButton playButton;
    private final CustomButton settingsButton;
    private final CustomButton creditsButton;
    private final CustomButton exitButton;

    public MainMenuScreen(GameMain game) {
        this.game = game;
        batch = game.getBatch();

        playButton = new CustomButton(GameInfo.PLAY_BUTTON_FILENAME, GameInfo.WIDTH/2f -150, GameInfo.HEIGHT/6f*4, batch);
        settingsButton = new CustomButton(GameInfo.SETTINGS_BUTTON_FILENAME, GameInfo.WIDTH/2f -150 , GameInfo.HEIGHT/6f*3 , batch);
        creditsButton = new CustomButton(GameInfo.CREDITS_BUTTON_FILENAME,  GameInfo.WIDTH/2f -150 , GameInfo.HEIGHT/6f*2, batch);
        exitButton = new CustomButton(GameInfo.EXIT_BUTTON_FILENAME, GameInfo.WIDTH/2f -150 , GameInfo.HEIGHT/6f , batch);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

//        playButton.updatePosition();
//        settingsButton.updatePosition();
//        creditsButton.updatePosition();
//        exitButton.updatePosition();

        batch.begin();

        playButton.draw();
        settingsButton.draw();
        creditsButton.draw();
        exitButton.draw();

        batch.end();
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
        playButton.dispose();
        settingsButton.dispose();
        creditsButton.dispose();
        exitButton.dispose();
    }

    class CustomButton extends Sprite {
        private final SpriteBatch batch;
        public CustomButton(String filename, float x, float y, SpriteBatch batch) {
            super(new Texture(filename));
            this.batch = batch;

            setPosition(x, y);
        }

        public void draw() {
            batch.draw(this, getX(), getY());
        }

        public void dispose() {
            getTexture().dispose();
        }

        public void updatePosition() {
            this.setPosition(this.getX() - this.getWidth()/2, this.getY()-this.getHeight()/2);
        }

    }

}
//        Gdx.input.setInputProcessor(new InputProcessor() {
//            @Override
//            public boolean keyDown(int keycode) {
//                return false;
//            }
//
//            @Override
//            public boolean keyUp(int keycode) {
//                return false;
//            }
//
//            @Override
//            public boolean keyTyped(char character) {
//                return false;
//            }
//
//            @Override
//            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
//                if (button == Input.Buttons.LEFT) {
//                    System.out.println("hey" + screenX + ". " + screenY);
//                    return true;
//                }
//                return false;
//            }
//
//            @Override
//            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
//                return false;
//            }
//
//            @Override
//            public boolean touchDragged(int screenX, int screenY, int pointer) {
//                return false;
//            }
//
//            @Override
//            public boolean mouseMoved(int screenX, int screenY) {
//                return false;
//            }
//
//            @Override
//            public boolean scrolled(float amountX, float amountY) {
//                return false;
//            }
//
//        });