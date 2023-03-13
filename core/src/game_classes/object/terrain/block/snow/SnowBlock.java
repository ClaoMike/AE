package game_classes.object.terrain.block.snow;

import com.badlogic.gdx.math.Vector2;
import game_classes.Constants;
import game_classes.object.terrain.block.Block;
import game_classes.screen.gameplay.GameUtils;

public class SnowBlock extends Block {
    public SnowBlock(GameUtils utils, Vector2 coordinates) {
        super(utils.game, Constants.SNOW_IMAGE_FILEPATH, utils.world, coordinates, false);
    }
}
