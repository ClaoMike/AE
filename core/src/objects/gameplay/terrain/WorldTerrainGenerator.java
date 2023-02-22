package objects.gameplay.terrain;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;
import objects.gameplay.Drawable;
import objects.gameplay.terrain.UI.BasicRoom;
import objects.gameplay.terrain.UI.DrawableMaze;
import objects.gameplay.terrain.UI.SafeRoom;

public class WorldTerrainGenerator implements Drawable {
    private final SpriteBatch batch;
    private final World world;
    private float x;
    private float y;
    private SafeRoom startRoom;
    private DrawableMaze maze;
    private SafeRoom endRoom;

    public WorldTerrainGenerator(SpriteBatch batch, World world, float x, float y) {
        this.world = world;
        this.batch = batch;
        this.x = x;
        this.y = y;

        createStartPlatform();
        createMaze();
        createEndPlatform();
    }

    private void createStartPlatform() {
        startRoom = new SafeRoom(batch, world, x, y, true);

        x += startRoom.getSize();
        BasicRoom b = new BasicRoom(batch, world, 0, 0);
        y -= b.getSize();
        b.dispose();
    }

    private void createMaze() {
        maze = new DrawableMaze(batch, world, x, y);

        // update x and y for the end platform
        x += maze.getWidth();
        y = maze.getExitY() + 700;
    }

    private void createEndPlatform() {
        endRoom = new SafeRoom(batch, world, x, y, false);
    }

    public void draw() {
        startRoom.draw();
        maze.draw();
        endRoom.draw();
    }

    public void updatePosition() {
        startRoom.updatePosition();
        maze.updatePosition();
        endRoom.updatePosition();
    }

    public void dispose() {
        startRoom.dispose();
        maze.dispose();
        endRoom.dispose();
    }
}
