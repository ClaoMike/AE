package game_classes.object.terrain.block.snow;

import com.badlogic.gdx.math.Vector2;

import game_classes.Constants;
import game_classes.object.blueprint.UpdatedCustomSprite;

public class SnowSprite extends UpdatedCustomSprite {
    public SnowSprite(Vector2 coordinates) {
        super(Constants.SNOW_IMAGE_FILEPATH, coordinates);
    }
}