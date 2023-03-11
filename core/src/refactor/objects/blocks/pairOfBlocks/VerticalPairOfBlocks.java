package refactor.objects.blocks.pairOfBlocks;

import com.badlogic.gdx.math.Vector2;

import refactor.screens.gameplay.GameUtils;

public class VerticalPairOfBlocks extends PairOfBlocks {
    public VerticalPairOfBlocks(GameUtils utils, Vector2 coordinates) {
        super(utils, coordinates, true);
    }
}
