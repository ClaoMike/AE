package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import helpers.GameInfo;

class CustomButton extends Sprite {
    private final SpriteBatch batch;
    public CustomButton(String filename, SpriteBatch batch) {
        super(new Texture(filename));
        this.batch = batch;


    }

    public void draw() {
        batch.draw(this, getX(), getY());
    }

    public void dispose() {
        getTexture().dispose();
    }

    public void updatePosition(float x, float y) {
        setPosition(x, y);
    }

}