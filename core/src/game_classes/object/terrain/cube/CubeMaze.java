package game_classes.object.terrain.cube;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

import game_classes.Constants;
import game_classes.object.terrain.block.BlockTypes;
import game_classes.object.terrain.maze.Maze;
import game_classes.object.terrain.maze.Vertex;
import game_classes.screen.gameplay.GameUtils;

public class CubeMaze {
    private final Array<Cube> cubes = new Array<>();
    private final float endX;
    private final float exitY;

    public CubeMaze(int mazeSize, Vector2 coordinates, GameUtils utils, int entranceRow, int exitRow) {
        endX = coordinates.x + (mazeSize+1) * 4 * Constants.BLOCK_SIZE;
        exitY = coordinates.y - 4*Constants.BLOCK_SIZE * (exitRow+1);

        Maze maze = new Maze(mazeSize);
        Vector2 nextCoordinates = coordinates.cpy();

        for(int i = 0; i < maze.getVertices().size; i++) {
            nextCoordinates.x = coordinates.x;
            nextCoordinates.y -= 4 * Constants.BLOCK_SIZE;
            for(int j = 0; j < maze.getVertices().get(i).size; j++) {
                Vertex current = maze.getVertices().get(i).get(j);
                Array<Vertex> neighbours = current.getNeighbours();

                BlockTypes[][] arrangement = CubeArrangements.getFreshCopyOf(CubeArrangements.Maze.corners);
                boolean leftWall, upWall, rightWall, downWall;
                leftWall = upWall = rightWall = downWall = true;

                for(Vertex v: neighbours) {
                    if(v.getI() == current.getI()+1 && v.getJ() == current.getJ()) {
                        arrangement[3][1] = BlockTypes.DIRT_SNOW_LEFT;
                        arrangement[3][2] = BlockTypes.DIRT_SNOW_RIGHT;
                        downWall = false;
                    }

                    if(v.getI() == current.getI()-1 && v.getJ() == current.getJ()) {
                        arrangement[0][1] = BlockTypes.DIRT_SNOW_LEFT;
                        arrangement[0][2] = BlockTypes.DIRT_SNOW_RIGHT;
                        upWall =false;
                    }

                    if(v.getJ() == current.getJ()-1 && v.getI() == current.getI()) {
                        arrangement[1][0] = BlockTypes.DIRT_SNOW_UP;
                        arrangement[2][0] = BlockTypes.DIRT_SNOW_DOWN;
                        leftWall = false;
                    }

                    if(v.getJ() == current.getJ()+1 && v.getI() == current.getI()) {
                        arrangement[1][3] = BlockTypes.DIRT_SNOW_UP;
                        arrangement[2][3] = BlockTypes.DIRT_SNOW_DOWN;
                        rightWall = false;
                    }

                }

                if(downWall) {
                    arrangement[3][1] = BlockTypes.SNOW_BODY;
                    arrangement[3][2] = BlockTypes.SNOW_BODY;

                    if(rightWall){
                        arrangement[2][2] = BlockTypes.DIRT_SNOW_CORNER_BOTTOM_RIGHT;
                    } else {
                        arrangement[2][2] = BlockTypes.DIRT_SNOW_DOWN;
                    }

                    if(leftWall){
                        arrangement[2][1] = BlockTypes.DIRT_SNOW_CORNER_BOTTOM_LEFT;
                    } else {
                        arrangement[2][1] = BlockTypes.DIRT_SNOW_DOWN;
                    }
                }

                if(upWall) {
                    arrangement[0][1] = BlockTypes.SNOW_BODY;
                    arrangement[0][2] = BlockTypes.SNOW_BODY;

                    if(rightWall){
                        arrangement[1][2] = BlockTypes.DIRT_SNOW_CORNER_TOP_RIGHT;
                    } else {
                        arrangement[1][2] = BlockTypes.DIRT_SNOW_UP;
                    }

                    if(leftWall){
                        arrangement[1][1] = BlockTypes.DIRT_SNOW_CORNER_TOP_LEFT;
                    } else {
                        arrangement[1][1] = BlockTypes.DIRT_SNOW_UP;
                    }
                }

                if(leftWall) {
                    arrangement[1][0] = BlockTypes.SNOW_BODY;
                    arrangement[2][0] = BlockTypes.SNOW_BODY;

                    if(!upWall) {
                        arrangement[1][1] = BlockTypes.DIRT_SNOW_LEFT;
                    }

                    if(!downWall) {
                        arrangement[2][1] = BlockTypes.DIRT_SNOW_LEFT;
                    }
                }

                if(rightWall) {
                    arrangement[1][3] = BlockTypes.SNOW_BODY;
                    arrangement[2][3] = BlockTypes.SNOW_BODY;
                    if(!upWall) {
                        arrangement[1][2] = BlockTypes.DIRT_SNOW_RIGHT;
                    }
                    if(!downWall) {
                        arrangement[2][2] = BlockTypes.DIRT_SNOW_RIGHT;
                    }
                }

                if(i == entranceRow && j == 0){
                    arrangement[1][0] = BlockTypes.DIRT_SNOW_UP;
                    arrangement[2][0] = BlockTypes.DIRT_SNOW_DOWN;

                    if(upWall) {
                        arrangement[1][1] = BlockTypes.DIRT_SNOW_UP;
                    } else {
                        arrangement[1][1] = BlockTypes.DIRT_SPRITE;
                    }

                    if (downWall) {
                        arrangement[2][1] = BlockTypes.DIRT_SNOW_DOWN;
                    } else {
                        arrangement[2][1] = BlockTypes.DIRT_SPRITE;
                    }

                }

                if(i == exitRow && j == mazeSize-1){
                    arrangement[1][3] = BlockTypes.DIRT_SNOW_UP;
                    arrangement[2][3] = BlockTypes.DIRT_SNOW_DOWN;

                    if(upWall) {
                        arrangement[1][2] = BlockTypes.DIRT_SNOW_UP;
                    } else {
                        arrangement[1][2] = BlockTypes.DIRT_SPRITE;
                    }

                    if (downWall) {
                        arrangement[2][2] = BlockTypes.DIRT_SNOW_DOWN;
                    } else {
                        arrangement[2][2] = BlockTypes.DIRT_SPRITE;
                    }

                }

                nextCoordinates.x += 4 * Constants.BLOCK_SIZE;
                Cube cube = new Cube(arrangement, nextCoordinates, utils);
                cubes.add(cube);

                if(i == 0){
                    Vector2 borderCoordinates = new Vector2(nextCoordinates.x, nextCoordinates.y + 4 * Constants.BLOCK_SIZE);
                    Cube border = new Cube(CubeArrangements.Maze.snow, borderCoordinates, utils);
                    cubes.add(border);
                }

                if(i == mazeSize-1){
                    Vector2 borderCoordinates = new Vector2(nextCoordinates.x, nextCoordinates.y - 4 * Constants.BLOCK_SIZE);
                    Cube border = new Cube(CubeArrangements.Maze.snow, borderCoordinates, utils);
                    cubes.add(border);
                }

                if(j == 0) {
                    if(i != entranceRow) {
                        Vector2 borderCoordinates = new Vector2(nextCoordinates.x - 4 * Constants.BLOCK_SIZE, nextCoordinates.y);
                        Cube border = new Cube(CubeArrangements.Maze.snow, borderCoordinates, utils);
                        cubes.add(border);

                        borderCoordinates = new Vector2(nextCoordinates.x - 8 * Constants.BLOCK_SIZE, nextCoordinates.y);
                        border = new Cube(CubeArrangements.Maze.snow, borderCoordinates, utils);
                        cubes.add(border);
                    }
                }

                if(j == mazeSize-1) {
                    if(i != exitRow) {
                        Vector2 borderCoordinates = new Vector2(nextCoordinates.x + 4 * Constants.BLOCK_SIZE, nextCoordinates.y);
                        Cube border = new Cube(CubeArrangements.Maze.snow, borderCoordinates, utils);
                        cubes.add(border);

                        borderCoordinates = new Vector2(nextCoordinates.x + 8 * Constants.BLOCK_SIZE, nextCoordinates.y);
                        border = new Cube(CubeArrangements.Maze.snow, borderCoordinates, utils);
                        cubes.add(border);
                    }
                }

            }
        }

        // fill top left corner with snow
        Vector2 borderCoordinates = new Vector2(coordinates.x, coordinates.y);
        Cube border = new Cube(CubeArrangements.Maze.snow, borderCoordinates, utils);
        cubes.add(border);

        borderCoordinates = new Vector2(coordinates.x - 4 * Constants.BLOCK_SIZE, coordinates.y);
        border = new Cube(CubeArrangements.Maze.snow, borderCoordinates, utils);
        cubes.add(border);

        // fill top right corner with snow
        borderCoordinates = new Vector2(coordinates.x + 4 * Constants.BLOCK_SIZE * (mazeSize+1), coordinates.y);
        border = new Cube(CubeArrangements.Maze.snow, borderCoordinates, utils);
        cubes.add(border);

        borderCoordinates = new Vector2(coordinates.x + 4 * Constants.BLOCK_SIZE * (mazeSize+2), coordinates.y);
        border = new Cube(CubeArrangements.Maze.snow, borderCoordinates, utils);
        cubes.add(border);

        // fill bottom left corner with snow
        borderCoordinates = new Vector2(coordinates.x, coordinates.y - 4 * Constants.BLOCK_SIZE * (mazeSize+1));
        border = new Cube(CubeArrangements.Maze.snow, borderCoordinates, utils);
        cubes.add(border);

        borderCoordinates = new Vector2(coordinates.x - 4 * Constants.BLOCK_SIZE, coordinates.y - 4 * Constants.BLOCK_SIZE * (mazeSize+1));
        border = new Cube(CubeArrangements.Maze.snow, borderCoordinates, utils);
        cubes.add(border);

        // fill bottom right corner with snow
        borderCoordinates = new Vector2(coordinates.x + 4 * Constants.BLOCK_SIZE * (mazeSize+1), coordinates.y - 4 * Constants.BLOCK_SIZE * (mazeSize+1));
        border = new Cube(CubeArrangements.Maze.snow, borderCoordinates, utils);
        cubes.add(border);

        borderCoordinates = new Vector2(coordinates.x + 4 * Constants.BLOCK_SIZE * (mazeSize+2), coordinates.y - 4 * Constants.BLOCK_SIZE * (mazeSize+1));
        border = new Cube(CubeArrangements.Maze.snow, borderCoordinates, utils);
        cubes.add(border);
    }

    public void updatePosition() {
        for (Cube cube : cubes) {
            cube.updatePosition();
        }
    }

    public void draw() {
        for (Cube cube : cubes) {
            cube.draw();
        }
    }

    public void dispose() {
        for (Cube cube : cubes) {
            cube.dispose();
        }
    }

    public float getEndX() {
        return endX;
    }

    public float getExitY() {
        return exitY;
    }

}
