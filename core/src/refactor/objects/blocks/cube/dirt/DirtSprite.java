package refactor.objects.blocks.cube.dirt;

import com.badlogic.gdx.math.Vector2;

import refactor.Constants;
import refactor.objects.blueprints.UpdatedCustomSprite;

public class DirtSprite extends UpdatedCustomSprite {
    public DirtSprite(Vector2 coordinates) {
        super(Constants.DIRT_IMAGE_FILEPATH, coordinates);
    }
}


