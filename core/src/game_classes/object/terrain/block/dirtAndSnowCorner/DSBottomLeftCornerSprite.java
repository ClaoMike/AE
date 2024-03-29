package game_classes.object.terrain.block.dirtAndSnowCorner;

import com.badlogic.gdx.math.Vector2;

import game_classes.Constants;
import game_classes.object.blueprint.UpdatedCustomSprite;

public class DSBottomLeftCornerSprite extends UpdatedCustomSprite {
    public DSBottomLeftCornerSprite(Vector2 coordinates) {
        super(Constants.DIRT_WITH_SNOW_CORNER_BOTTOM_LEFT_IMAGE_FILEPATH, coordinates);
    }
}
