package refactor.objects.blocks;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

import dev.clao.GameMain;
import refactor.screens.gameplay.GameUtils;

public class PairOfBlocks extends StructureOfBlocks {
    public PairOfBlocks(GameUtils utils, Vector2 coordinates) {
        super(utils, coordinates);
    }
}