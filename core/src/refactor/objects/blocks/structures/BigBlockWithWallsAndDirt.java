package refactor.objects.blocks.structures;

import com.badlogic.gdx.math.Vector2;

import refactor.objects.Directions;
import refactor.screens.gameplay.GameUtils;

public class BigBlockWithWallsAndDirt extends  BigBlockWithWalls {
    public BigBlockWithWallsAndDirt(GameUtils utils, Vector2 coordinates, Directions[] wallDirections) {
        super(utils, coordinates, wallDirections);
    }
}
