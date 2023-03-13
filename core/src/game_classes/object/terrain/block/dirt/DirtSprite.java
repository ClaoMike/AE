package game_classes.object.terrain.block.dirt;

import com.badlogic.gdx.math.Vector2;

import game_classes.Constants;
import game_classes.object.blueprint.UpdatedCustomSprite;

public class DirtSprite extends UpdatedCustomSprite {
    public DirtSprite(Vector2 coordinates) {
        super(Constants.DIRT_IMAGE_FILEPATH, coordinates);
    }
}


