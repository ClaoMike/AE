package refactor.objects.blocks.cube.dirtAndSnow;

import com.badlogic.gdx.math.Vector2;

import refactor.Constants;
import refactor.objects.blueprints.UpdatedCustomSprite;

public class DSLeftSprite extends UpdatedCustomSprite {
    public DSLeftSprite(Vector2 coordinates) {
        super(Constants.DIRT_WITH_SNOW_LEFT_IMAGE_FILEPATH, coordinates);
    }
}
