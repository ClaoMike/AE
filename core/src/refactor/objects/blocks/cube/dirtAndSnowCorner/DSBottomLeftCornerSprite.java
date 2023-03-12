package refactor.objects.blocks.cube.dirtAndSnowCorner;

import com.badlogic.gdx.math.Vector2;

import refactor.Constants;
import refactor.objects.blueprints.UpdatedCustomSprite;

public class DSBottomLeftCornerSprite extends UpdatedCustomSprite {
    public DSBottomLeftCornerSprite(Vector2 coordinates) {
        super(Constants.DIRT_WITH_SNOW_CORNER_BOTTOM_LEFT_IMAGE_FILEPATH, coordinates);
    }
}
