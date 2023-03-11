package refactor.objects.blocks.structures;

import com.badlogic.gdx.math.Vector2;

import refactor.objects.blocks.pairOfBlocks.HorizontalPairOfBlocks;
import refactor.screens.gameplay.GameUtils;

public class HorizontalRowOfBlocks extends StructureOfBlocks {
    public HorizontalRowOfBlocks(GameUtils utils, Vector2 coordinates, int numberOfPairs, boolean reverse) {
        super(utils, coordinates);

        Vector2 nextCoordinates = coordinates.cpy();
        if(reverse) {
            nextCoordinates.x = coordinates.x - 2 * blockSize.x;
        }

        for(int i =0; i< numberOfPairs; i++) {
            HorizontalPairOfBlocks pair1 = new HorizontalPairOfBlocks(utils, nextCoordinates);
            blocks.addAll(pair1.blocks);
            if(reverse) {
                nextCoordinates.x = nextCoordinates.x - 2 * blockSize.x;
            } else{
                nextCoordinates.x = nextCoordinates.x + 2 * blockSize.x;
            }
        }

    }
}
