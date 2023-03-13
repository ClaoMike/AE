package refactor.objects.blocks;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

import refactor.objects.blocks.cube.Cube;
import refactor.objects.blocks.cube.CubeArrangements;
import refactor.objects.maze.Maze;
import refactor.objects.maze.Vertex;
import refactor.screens.gameplay.GameUtils;

public class CubeMaze {
    private Maze maze;
    private Array<Cube> cubes = new Array<>();

    public CubeMaze(int mazeSize, Vector2 coordinates, GameUtils utils, int entranceRow) {
        maze = new Maze(mazeSize);
        Vector2 nextCoordinates = coordinates.cpy();

        for(int i = 0; i < maze.getVertices().size; i++) {
            nextCoordinates.x = coordinates.x;
            nextCoordinates.y -= 400;
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

                nextCoordinates.x += 400;
                Cube cube = new Cube(arrangement, nextCoordinates, utils);
                cubes.add(cube);
            }
        }
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

}
