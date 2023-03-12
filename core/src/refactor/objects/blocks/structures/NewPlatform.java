package refactor.objects.blocks.structures;

import com.badlogic.gdx.math.Vector2;

import refactor.objects.Directions;
import refactor.objects.blueprints.CustomSprite;
import refactor.screens.gameplay.GameUtils;

public class NewPlatform extends StructureOfBlocks{

    public NewPlatform(GameUtils utils, Vector2 coordinates, int count) {
        super(utils, coordinates);

        Directions[] directions = {Directions.UP, Directions.DOWN};
        Vector2 nextCoordinates = coordinates.cpy();
        for(int i = 1; i <= count; i++) {
            BigBlockWithWalls b = new BigBlockWithWalls(utils, nextCoordinates, directions);
            blocks.addAll(b.blocks);
            nextCoordinates = new Vector2(coordinates.x + b.getWidth()*i, coordinates.y);
        }
    }

}
