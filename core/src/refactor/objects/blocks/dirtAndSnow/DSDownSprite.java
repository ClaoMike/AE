package refactor.objects.blocks.dirtAndSnow;

import com.badlogic.gdx.math.Vector2;

import refactor.Constants;
import refactor.objects.blueprints.UpdatedCustomSprite;

public class DSDownSprite extends UpdatedCustomSprite {
    public DSDownSprite(Vector2 coordinates) {
        super(Constants.DIRT_WITH_SNOW_DOWN_IMAGE_FILEPATH, coordinates);
    }
}
