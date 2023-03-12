package refactor.objects.blueprints;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class CustomSprite extends Sprite {
    public CustomSprite(String filepath) {
        super(new Texture(filepath));
    }

    public void dispose() {
        getTexture().dispose();
    }
}