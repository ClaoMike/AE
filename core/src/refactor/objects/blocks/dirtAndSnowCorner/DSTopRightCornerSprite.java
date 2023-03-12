package refactor.objects.blocks.dirtAndSnowCorner;

import com.badlogic.gdx.math.Vector2;

import refactor.Constants;
import refactor.objects.blueprints.UpdatedCustomSprite;

public class DSTopRightCornerSprite extends UpdatedCustomSprite {
    public DSTopRightCornerSprite(Vector2 coordinates) {
        super(Constants.DIRT_WITH_SNOW_CORNER_TOP_RIGHT_IMAGE_FILEPATH, coordinates);
    }
}
