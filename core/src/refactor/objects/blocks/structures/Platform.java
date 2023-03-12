package refactor.objects.blocks.structures;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

import refactor.screens.gameplay.GameUtils;

public class Platform extends StructureOfBlocks {
    public Platform(GameUtils utils, Vector2 coordinates) {
        super(utils, coordinates);

        float screenWidth = Gdx.graphics.getWidth();

        int front = (int)(screenWidth/4/blockSize.x) +1;
        float coef = 1.5f;

        Vector2 nextCoordinates = new Vector2( coordinates.x, coordinates.y + coef*blockSize.y);

        HorizontalRowOfBlocks row1 = new HorizontalRowOfBlocks(utils, nextCoordinates, front, false);

        nextCoordinates = new Vector2( coordinates.x, coordinates.y - coef* blockSize.y);

        HorizontalRowOfBlocks row2 = new HorizontalRowOfBlocks(utils, nextCoordinates, front, false);

        blocks.addAll(row1.blocks);
        blocks.addAll(row2.blocks);

        nextCoordinates = new Vector2( coordinates.x, coordinates.y - coef * blockSize.y);

        HorizontalRowOfBlocks row3 = new HorizontalRowOfBlocks(utils, nextCoordinates, front, true);

        nextCoordinates = new Vector2( coordinates.x, coordinates.y + coef * blockSize.y);

        HorizontalRowOfBlocks row4 = new HorizontalRowOfBlocks(utils, nextCoordinates, front, true);

        blocks.addAll(row3.blocks);
        blocks.addAll(row4.blocks);
    }
}
