package refactor.objects.blocks;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

import refactor.objects.blocks.cube.Cube;
import refactor.objects.blocks.cube.CubeArrangements;
import refactor.objects.maze.Maze;
import refactor.screens.gameplay.GameUtils;

public class CubeMaze {
    private Maze maze;
    private Array<Cube> cubes = new Array<>();

    public CubeMaze(int mazeSize, Vector2 coordinates, GameUtils utils) {
        maze = new Maze(mazeSize);
        Vector2 nextCoordinates = coordinates.cpy();

        for(int i = 0; i < maze.getVertices().size; i++) {
            nextCoordinates.x = coordinates.x;
            nextCoordinates.y -= 400;
            for(int j = 0; j < maze.getVertices().get(i).size; j++) {
                nextCoordinates.x += 400;
                Cube cube = new Cube(CubeArrangements.Connenction.leftArrangement, nextCoordinates, utils);
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
