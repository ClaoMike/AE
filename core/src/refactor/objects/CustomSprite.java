package refactor.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class CustomSprite extends Sprite {
    public CustomSprite(String filepath) {
        super(new Texture(filepath));
    }
}