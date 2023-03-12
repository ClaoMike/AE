package refactor.objects.blocks.dirtAndSnow;

import com.badlogic.gdx.math.Vector2;

import refactor.Constants;
import refactor.objects.blueprints.UpdatedCustomSprite;

public class DSRightSprite extends UpdatedCustomSprite {
    public DSRightSprite(Vector2 coordinates) {
        super(Constants.DIRT_WITH_SNOW_RIGHT_IMAGE_FILEPATH, coordinates);
    }
}
