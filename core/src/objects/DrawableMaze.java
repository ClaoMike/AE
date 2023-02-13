package objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

public class DrawableMaze implements Drawable {
   private Array<Array<Vertex>> maze;
   private Array<MazeRoom> drawableMaze = new Array<>();
   private SpriteBatch batch;
   private World world;

    public DrawableMaze(SpriteBatch batch, World world, float x, float y) {
        this.batch = batch;
        this.world = world;
        float newX = x;
        float brSize = 0;

        Maze m = new Maze();
        maze = m.getVertices();
        for(Array<Vertex> row: maze) {
            for(Vertex v: row) {

                // TODO:
                Array<BlockDirections> allowedDirections = new Array<>();
                allowedDirections.add(BlockDirections.DOWN);
                allowedDirections.add(BlockDirections.UP);
                allowedDirections.add(BlockDirections.RIGHT);
                allowedDirections.add(BlockDirections.LEFT);

                MazeRoom mr = new MazeRoom(batch, world, newX, y, allowedDirections);

                drawableMaze.add(mr);
                newX += mr.getSize();
                brSize = mr.getSize();
            }
            newX = x;
            y -= brSize;
        }
    }

    @Override
    public void draw() {
        for(MazeRoom br: drawableMaze) {
            br.draw();
        }
    }

    @Override
    public void updatePosition() {
        for(MazeRoom br: drawableMaze) {
            br.updatePosition();
        }
    }

    @Override
    public void dispose() {
        for(MazeRoom br: drawableMaze) {
            br.dispose();
        }
    }
}
