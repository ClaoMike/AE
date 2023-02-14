package objects.terrain;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

import helpers.GameInfo;
import objects.AtomicObject;
import objects.Drawable;
import objects.terrain.UI.BasicRoom;
import objects.terrain.UI.DrawableMaze;
import objects.terrain.UI.Platform;

public class WorldTerrainGenerator implements Drawable {
    private float initalX = GameInfo.START_POSITION_X;
    private float initalY = GameInfo.START_POSITION_Y;
    private final World world;
    private final SpriteBatch batch;

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

        // update x and y for the maze
        BasicRoom br = new BasicRoom(batch, world, 0, 0);
        AtomicObject ao = new AtomicObject(GameInfo.PLAYER, 0, 0, world, BodyDef.BodyType.StaticBody, 1, false, false);
        initalY = br.getSize() - ao.getHeight();
        initalX = startPlatform.getWidth();
        br.dispose();
        ao.dispose();
    }

    private void createMaze() {
        maze = new DrawableMaze(batch, world, initalX, initalY);

        // update x and y for the end platform
        initalX += maze.getWidth();
        initalY = maze.getExitY();
    }

    private void createEndPlatform() {
        endPlatform = new Platform(batch, world, initalX, initalY);
    }

    public void draw() {
        startPlatform.draw();
        maze.draw();
        endPlatform.draw();
    }

    public void updatePosition() {
        startPlatform.updatePosition();
        maze.updatePosition();
        endPlatform.updatePosition();
    }

    public void dispose() {
        startPlatform.dispose();
        maze.dispose();
        endPlatform.dispose();
    }
}
