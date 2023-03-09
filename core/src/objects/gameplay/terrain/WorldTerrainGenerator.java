package objects.gameplay.terrain;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;
import objects.gameplay.Drawable;
import objects.gameplay.terrain.ui.BasicRoom;
import objects.gameplay.terrain.ui.DrawableMaze;
import objects.gameplay.terrain.ui.SafeRoom;

public class WorldTerrainGenerator implements Drawable {
    private final SpriteBatch batch;
    private final World world;
    private float x;
    private float y;
    private SafeRoom startRoom;
    private DrawableMaze maze;
    private SafeRoom endRoom;
    private final boolean debugMode;
    private final int cellsPerRow;

    public WorldTerrainGenerator(SpriteBatch batch, World world, float x, float y, boolean debugMode,int cellsPerRow) {
        this.world = world;
        this.batch = batch;
        this.x = x;
        this.y = y;
        this.debugMode = debugMode;
        this.cellsPerRow = cellsPerRow;

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
        maze = new DrawableMaze(batch, world, x, y, debugMode, cellsPerRow);

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
