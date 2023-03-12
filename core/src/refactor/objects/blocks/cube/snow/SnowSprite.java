package refactor.objects.blocks.cube.snow;

import com.badlogic.gdx.math.Vector2;

import refactor.Constants;
import refactor.objects.blueprints.UpdatedCustomSprite;

public class SnowSprite extends UpdatedCustomSprite {
    public SnowSprite(Vector2 coordinates) {
        super(Constants.SNOW_IMAGE_FILEPATH, coordinates);
    }
}