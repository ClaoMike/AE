package refactor.objects;

import static refactor.objects.Directions.DOWN;
import static refactor.objects.Directions.LEFT;
import static refactor.objects.Directions.RIGHT;
import static refactor.objects.Directions.UP;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

import objects.gameplay.player.MainPlayer;
import refactor.objects.Directions;

public class PlayerInputProcessor implements InputProcessor {
    private final Player player;

    public PlayerInputProcessor(Player player) {
        this.player = player;
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public boolean keyDown(int keycode) {
        switch(keycode) {
            case Input.Keys.A:
                player.move(LEFT);
                break;
            case Input.Keys.D:
                player.move(RIGHT);
                break;
            case Input.Keys.W:
                player.move(UP);
                break;
            case Input.Keys.S:
                player.move(DOWN);
                break;
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        switch(keycode) {
            case Input.Keys.A:
            case Input.Keys.D:
                player.stopMoving(LEFT);
                break;
            case Input.Keys.W:
            case Input.Keys.S:
                player.stopMoving(UP);
                break;
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
