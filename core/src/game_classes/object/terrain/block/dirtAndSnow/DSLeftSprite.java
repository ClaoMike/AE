package game_classes.object.terrain.block.dirtAndSnow;

import com.badlogic.gdx.math.Vector2;

import game_classes.Constants;
import game_classes.object.blueprint.UpdatedCustomSprite;

public class DSLeftSprite extends UpdatedCustomSprite {
    public DSLeftSprite(Vector2 coordinates) {
        super(Constants.DIRT_WITH_SNOW_LEFT_IMAGE_FILEPATH, coordinates);
    }
}
