package refactor.objects.blocks;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

import dev.clao.GameMain;
import refactor.screens.gameplay.GameUtils;

public class RowOfBlocksWithEndpointsOnly extends StructureOfBlocks {

    public RowOfBlocksWithEndpointsOnly(GameUtils utils, Vector2 coordinates) {
        super(utils, coordinates);

        Block b1 = new Block(game, blockFilepath, world, coordinates, false);
        blocks.add(b1);
        Vector2 nextCoordinates = new Vector2(this.coordinates.x + 3 * blockSize.x, this.coordinates.y);

        Block b2 = new Block(game, blockFilepath, world, nextCoordinates, false);
        blocks.add(b2);
    }

    public Vector2 getSize() {

        return this.blockSize ;
    }


}
