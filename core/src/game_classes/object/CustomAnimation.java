package game_classes.object;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import game_classes.screen.gameplay.GameUtils;

public class CustomAnimation {
    private final GameUtils utils;
    private final Animation<TextureRegion> animation;
    private final Texture texture;
    private float stateTime;
    private float x = 0;
    private float y = 0;

    public CustomAnimation(String filepath, float frameDuration, GameUtils utils, int FRAME_COLS, int FRAME_ROWS) {
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

        animation = new Animation<>(frameDuration, frames);
        stateTime = 0f;
    }

    public void draw() {
        stateTime += Gdx.graphics.getDeltaTime();
        TextureRegion currentFrame = animation.getKeyFrame(stateTime, true);
//        currentFrame.flip(true, false);
        utils.game.getBatch().draw(currentFrame, x, y);

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
