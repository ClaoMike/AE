package game_classes.object.terrain.block.dirtAndSnow;

import com.badlogic.gdx.math.Vector2;

import game_classes.Constants;
import game_classes.object.blueprint.UpdatedCustomSprite;

public class DSUpSprite extends UpdatedCustomSprite {

    public DSUpSprite(Vector2 coordinates) {
        super(Constants.DIRT_WITH_SNOW_UP_IMAGE_FILEPATH, coordinates);
    }

}
