package refactor.objects.blocks;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

import dev.clao.GameMain;

public class RowOfBlocksWithEndpointsOnly extends StructureOfBlocks {

    public RowOfBlocksWithEndpointsOnly(GameMain game, World world, Vector2 coordinates) {
        super(game, world, coordinates);

        Block b1 = new Block(game, blockFilepath, world, coordinates, false);
        blocks.add(b1);
        Vector2 nextCoordinates = new Vector2(coordinates.x + 3 * blockSize.x, coordinates.y);

        Block b2 = new Block(game, blockFilepath, world, nextCoordinates, false);
        blocks.add(b2);
    }

    public Vector2 getSize() {

        return this.blockSize ;
    }


}
