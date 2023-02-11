package objects;

import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

import helpers.GameInfo;

public class MazeRoom {
    private int numberOfDirtBlocks = 9;
    private boolean[] allowedDirections = {false, false, false, false};
    Array<DirtBlock> dirt = new Array<>();
    private float x;
    private float y;
    private World world;

    public MazeRoom(World world, float x, float y) {
        this.world = world;
        this.x = x;
        this.y = y;

        createBottomRow();
        createMiddleRow();
        createTopRow();
    }

    private void createBottomRow() {

    }

    private void createMiddleRow() {

    }

    private void createTopRow() {

    }
}
