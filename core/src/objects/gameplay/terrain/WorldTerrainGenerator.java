package objects.gameplay.terrain;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

import helpers.GameInfo;
import objects.gameplay.AtomicObject;
import objects.gameplay.Drawable;
import objects.gameplay.terrain.UI.BasicRoom;
import objects.gameplay.terrain.UI.DrawableMaze;
import objects.gameplay.terrain.UI.Platform;
import objects.gameplay.terrain.UI.SafeRoom;

public class WorldTerrainGenerator implements Drawable {
    private float initalX = 0;
    private float initalY = 0;
    private final World world;
    private final SpriteBatch batch;

    private Platform startPlatform;
    private DrawableMaze maze;
    private Platform endPlatform;

    private SafeRoom s;

    public WorldTerrainGenerator(SpriteBatch batch, World world, float x, float y) {
        this.world = world;
        this.batch = batch;

        s = new SafeRoom(batch, world, x, y);

//        createStartPlatform();
//        createMaze();
//        createEndPlatform();
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
        s.draw();
//        startPlatform.draw();
//        maze.draw();
//        endPlatform.draw();
    }

    public void updatePosition() {
        s.updatePosition();
//        startPlatform.updatePosition();
//        maze.updatePosition();
//        endPlatform.updatePosition();
    }

    public void dispose() {
        s.dispose();
//        startPlatform.dispose();
//        maze.dispose();
//        endPlatform.dispose();
    }
}
