package objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

import helpers.GameInfo;

public class WorldTerrainGenerator implements Drawable {
    private float initalX = GameInfo.START_POSITION_X;
    private float initalY = GameInfo.START_POSITION_Y;
    private World world;
    private SpriteBatch batch;

    private Platform startPlatform;
    private DrawableMaze maze;
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
        BasicRoom br = new BasicRoom(batch, world, 0, 0);
        AtomicObject ao = new AtomicObject(GameInfo.PLAYER, 0, 0, world, BodyDef.BodyType.StaticBody, 1);
        initalY = br.getSize() - ao.getHeight();
        initalX = startPlatform.getWidth();
        br.dispose();
        ao.dispose();
    }

    private void createMaze() {
        maze = new DrawableMaze(batch, world, initalX, initalY);
    }

    private void createEndPlatform() {

    }

    public void draw() {
        startPlatform.draw();
        maze.draw();
    }

    public void updatePosition() {
        startPlatform.updatePosition();
        maze.updatePosition();
    }

    public void dispose() {
        startPlatform.dispose();
        maze.dispose();
    }
}
