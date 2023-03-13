package game_classes.object.terrain.block.dirtAndSnowCorner;

import com.badlogic.gdx.math.Vector2;

import game_classes.Constants;
import game_classes.object.blueprint.UpdatedCustomSprite;

public class DSTopLeftCornerSprite extends UpdatedCustomSprite {
    public DSTopLeftCornerSprite(Vector2 coordinates) {
        super(Constants.DIRT_WITH_SNOW_CORNER_TOP_LEFT_IMAGE_FILEPATH, coordinates);
    }
}
