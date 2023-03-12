package refactor.objects.blocks.cube.dirtAndSnowCorner;

import com.badlogic.gdx.math.Vector2;

import refactor.Constants;
import refactor.objects.blueprints.UpdatedCustomSprite;

public class DSTopLeftCornerSprite extends UpdatedCustomSprite {
    public DSTopLeftCornerSprite(Vector2 coordinates) {
        super(Constants.DIRT_WITH_SNOW_CORNER_TOP_LEFT_IMAGE_FILEPATH, coordinates);
    }
}
