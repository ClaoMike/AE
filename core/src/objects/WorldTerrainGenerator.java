package objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;

import helpers.GameInfo;

public class WorldTerrainGenerator implements Drawable {
    private float initalX = GameInfo.START_POSITION_X;
    private float initalY = GameInfo.START_POSITION_Y;
    private World world;
    private SpriteBatch batch;

    private Platform startPlatform;
//    private Maze maze;
    private Platform endPlatform;

    public WorldTerrainGenerator(SpriteBatch batch, World world) {
        this.world = world;
        this.batch = batch;

        createStartPlatform();
        createMaze();
        createEndPlatform();
    }

    private void createStartPlatform() {
        startPlatform = new Platform(batch, world, initalX, initalY);
    }

    private void createMaze() {

    }

    private void createEndPlatform() {

    }

    public void draw() {
        startPlatform.draw();
    }

    public void updatePosition() {
        startPlatform.updatePosition();
    }

    public void dispose() {
        startPlatform.dispose();
    }
}
