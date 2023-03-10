package refactor.objects.blocks;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

import dev.clao.GameMain;

public class BigBlockWithCornersOnly extends StructureOfBlocks{

    public BigBlockWithCornersOnly(GameMain game, World world, Vector2 coordinates) {
        super(game, world, coordinates);

        RowOfBlocksWithEndpointsOnly row1 = new RowOfBlocksWithEndpointsOnly(game, world, coordinates);
        Vector2 nextCoordinates =  new Vector2(coordinates.x, coordinates.y + row1.getSize().y * 3);

        RowOfBlocksWithEndpointsOnly row2 = new RowOfBlocksWithEndpointsOnly(game, world, nextCoordinates);

        blocks.addAll(row1.blocks);
        blocks.addAll(row2.blocks);
    }
}
