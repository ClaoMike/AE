package refactor.objects.blocks.snow;

import com.badlogic.gdx.math.Vector2;
import refactor.Constants;
import refactor.objects.blocks.Block;
import refactor.screens.gameplay.GameUtils;

public class SnowBlock extends Block {
    public SnowBlock(GameUtils utils, Vector2 coordinates) {
        super(utils.game, Constants.SNOW_IMAGE_FILEPATH, utils.world, coordinates, false);
    }
}
