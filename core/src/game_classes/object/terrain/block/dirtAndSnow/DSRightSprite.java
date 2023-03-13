package game_classes.object.terrain.block.dirtAndSnow;

import com.badlogic.gdx.math.Vector2;

import game_classes.Constants;
import game_classes.object.blueprint.UpdatedCustomSprite;

public class DSRightSprite extends UpdatedCustomSprite {
    public DSRightSprite(Vector2 coordinates) {
        super(Constants.DIRT_WITH_SNOW_RIGHT_IMAGE_FILEPATH, coordinates);
    }
}
