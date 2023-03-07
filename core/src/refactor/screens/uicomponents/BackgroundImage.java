package refactor.screens.uicomponents;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BackgroundImage {
    private final SpriteBatch batch;
    private final Texture texture;
    private final Sprite sprite;

    public BackgroundImage(String filepath, float width, float height, SpriteBatch batch) {
        this.batch = batch;

        texture = new Texture(Gdx.files.internal(filepath));
        sprite = new Sprite(texture);
        sprite.setSize(width, height);
    }

    public void draw() {
        sprite.draw(batch);
    }

    public void resize(int width, int height) {
        sprite.setSize(width, height);
    }

    public void dispose() {
        texture.dispose();
    }
}