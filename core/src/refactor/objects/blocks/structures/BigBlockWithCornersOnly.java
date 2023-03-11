package refactor.objects.blocks.structures;

import com.badlogic.gdx.math.Vector2;
import refactor.screens.gameplay.GameUtils;

public class BigBlockWithCornersOnly extends StructureOfBlocks{

    public BigBlockWithCornersOnly(GameUtils utils, Vector2 coordinates) {
        super(utils, coordinates);

        RowOfBlocksWithEndpointsOnly row1 = new RowOfBlocksWithEndpointsOnly(utils, coordinates);
        Vector2 nextCoordinates =  new Vector2(coordinates.x, coordinates.y + row1.getSize().y * 3);

        RowOfBlocksWithEndpointsOnly row2 = new RowOfBlocksWithEndpointsOnly(utils, nextCoordinates);

        blocks.addAll(row1.blocks);
        blocks.addAll(row2.blocks);
    }
}
