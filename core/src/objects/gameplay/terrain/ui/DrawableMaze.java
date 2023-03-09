package objects.gameplay.terrain.ui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

import objects.gameplay.Drawable;
import objects.gameplay.terrain.back_end.Maze;
import objects.gameplay.terrain.back_end.Vertex;

public class DrawableMaze implements Drawable {
    private final Array<MazeRoom> drawableMaze = new Array<>();
    private float exitY;
    private int cellsPerRow;

    public DrawableMaze(SpriteBatch batch, World world, float x, float y, boolean debugMode, int cellsPerRow) {
        this.cellsPerRow = cellsPerRow;

        float newX = x;
        float brSize = 0;

        Maze m = new Maze(cellsPerRow);
        if(debugMode) {
            m.printToConsole();
        }
        Array<Array<Vertex>> maze = m.getVertices();
        int randomRow = maze.random().get(0).getI();
        int col = cellsPerRow - 1;

        for(Array<Vertex> row: maze) {
            for(Vertex v: row) {
                Array<BlockDirections> allowedDirections = getDirections(v);

                // if it's the maze entrance, demolish the wall
                if(v.getI() == 0 && v.getJ() == 0) {
                    allowedDirections.add(BlockDirections.LEFT);
                }

                // set exit
                if(v.getI() == randomRow && v.getJ() == col) {
                    allowedDirections.add(BlockDirections.RIGHT);
                }

                MazeRoom mr = new MazeRoom(batch, world, newX, y, allowedDirections);
                drawableMaze.add(mr);
                newX += mr.getSize();
                brSize = mr.getSize();

                exitY = -mr.getSize() * randomRow;
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

    public float getWidth() {
        return cellsPerRow * drawableMaze.get(0).getSize();
    }

    public float getExitY() {
        return exitY;
    }

}
