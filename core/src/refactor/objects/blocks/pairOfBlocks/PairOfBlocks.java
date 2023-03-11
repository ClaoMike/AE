package refactor.objects.blocks.pairOfBlocks;

import com.badlogic.gdx.math.Vector2;

import refactor.objects.blocks.Block;
import refactor.objects.blocks.structures.StructureOfBlocks;
import refactor.screens.gameplay.GameUtils;

public class PairOfBlocks extends StructureOfBlocks {
    public PairOfBlocks(GameUtils utils, Vector2 coordinates, boolean isVertical) {
        super(utils, coordinates);

        int s, t;
        s = 1;
        t = 0;
        if(isVertical) {
            s = 0;
            t = 1;
        }

        Block b1 = new Block(game, blockFilepath, world, coordinates, false);
        blocks.add(b1);
        Vector2 nextCoordinates = new Vector2(this.coordinates.x + blockSize.x * s, this.coordinates.y + + blockSize.x * t);

        Block b2 = new Block(game, blockFilepath, world, nextCoordinates, false);
        blocks.add(b2);
    }
}