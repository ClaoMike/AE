package objects.gameplay.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

public class PlayerInputProcessor implements InputProcessor {
    private final MainPlayer player;

    public PlayerInputProcessor(MainPlayer player) {
        this.player = player;
        Gdx.input.setInputProcessor(this);
    }

    public void detectUserInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            player.go(Directions.LEFT);
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            player.go(Directions.RIGHT);
        } else if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            player.go(Directions.UP);
        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            player.go(Directions.DOWN);
        }
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == Input.Keys.LEFT) {
            player.stopMoving(Directions.LEFT);
        }
        if (keycode == Input.Keys.RIGHT) {
            player.stopMoving(Directions.RIGHT);
        }
        if (keycode == Input.Keys.UP) {
            player.stopMoving(Directions.UP);
        }
        if (keycode == Input.Keys.DOWN) {
            player.stopMoving(Directions.DOWN);
        }
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
