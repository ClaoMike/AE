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
        m.printToConsole();
        maze = m.getVertices();
        for(Array<Vertex> row: maze) {
            for(Vertex v: row) {
                Array<BlockDirections> allowedDirections = getDirections(v);

                // if it's the maze entrance, demolish the wall
                if(v.getI() == 0 && v.getJ() == 0) {
                    allowedDirections.add(BlockDirections.LEFT);
                }

                MazeRoom mr = new MazeRoom(batch, world, newX, y, allowedDirections);
                drawableMaze.add(mr);
                newX += mr.getSize();
                brSize = mr.getSize();
            }
            newX = x;
            y -= brSize;
        }
    }

    private Array<BlockDirections> getDirections(Vertex v) {
        Array<BlockDirections> allowedDirections = new Array<>();
        Array<Vertex> neighbours = v.getNeighbours();

        for (Vertex n: neighbours) {
            if(v.getI() + 1 == n.getI()) {
                allowedDirections.add(BlockDirections.DOWN);
            } else if(v.getI() - 1 == n.getI()) {
                allowedDirections.add(BlockDirections.UP);
            } else if(v.getJ() + 1 == n.getJ()) {
                allowedDirections.add(BlockDirections.RIGHT);
            } else if(v.getJ() - 1 == n.getJ()) {
                allowedDirections.add(BlockDirections.LEFT);

            }
        }

        return allowedDirections;
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
