package game_classes.object;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import game_classes.screen.gameplay.GameUtils;

public class CustomAnimation {
    private GameUtils utils;
    private final int FRAME_COLS = 6, FRAME_ROWS = 5;
    private Animation<TextureRegion> animation;
    private Texture texture;
    private float stateTime;
    private float x = 0;
    private float y = 0;

    public CustomAnimation(String filepath, float frameDuration, GameUtils utils) {
        this.utils = utils;

        texture = new Texture(Gdx.files.internal(filepath));

        TextureRegion[][] tmp = TextureRegion.split(texture,
                texture.getWidth() / FRAME_COLS,
                texture.getHeight() / FRAME_ROWS);

        TextureRegion[] frames = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        int index = 0;
        for (int i = 0; i < FRAME_ROWS; i++) {
            for (int j = 0; j < FRAME_COLS; j++) {
                frames[index++] = tmp[i][j];
            }
        }

        animation = new Animation<TextureRegion>(frameDuration, frames);
        stateTime = 0f;
    }

    public void draw() {
        stateTime += Gdx.graphics.getDeltaTime();
        TextureRegion currentFrame = animation.getKeyFrame(stateTime, true);
        utils.game.getBatch().draw(currentFrame, x, y);
//        currentFrame.flip(true, false);
    }

    public void updatePosition(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void dispose() {
        texture.dispose();
    }

    public float getWidth() {
        return texture.getWidth();
    }

    public float getHeight() {
        return texture.getHeight();
    }

    public Texture getTexture() {
        return texture;
    }

}
