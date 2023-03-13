package game_classes.object.terrain.block.dirtAndSnow;

import com.badlogic.gdx.math.Vector2;

import game_classes.Constants;
import game_classes.object.blueprint.UpdatedCustomSprite;

public class DSDownSprite extends UpdatedCustomSprite {
    public DSDownSprite(Vector2 coordinates) {
        super(Constants.DIRT_WITH_SNOW_DOWN_IMAGE_FILEPATH, coordinates);
    }
}
