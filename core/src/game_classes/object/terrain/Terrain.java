package game_classes.object.terrain;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

import game_classes.Constants;
import game_classes.object.Directions;
import game_classes.object.terrain.cube.CubeMaze;
import game_classes.object.terrain.platform.Platform;
import game_classes.screen.gameplay.GameUtils;

public class Terrain {
    private final Platform startPlatform;
    private final CubeMaze maze;
    private final Platform endPlatform;

    public Terrain(GameUtils utils, Vector2 coordinates) {
        float screenWidth = Gdx.graphics.getWidth();
        Random rand = new Random();

        coordinates = new Vector2(coordinates.x -screenWidth/2 - 4 * Constants.BLOCK_SIZE, coordinates.y + 1.5f * Constants.BLOCK_SIZE);
        startPlatform = new Platform(coordinates, (int)(screenWidth /Constants.BLOCK_SIZE /4), Directions.LEFT, utils);

        int n = rand.nextInt(utils.game.settings.getMazeSize()) + 1;
        Vector2 mazeCoordinates = new Vector2(startPlatform.getEndX(), 1.5f * Constants.BLOCK_SIZE + n * 4 * Constants.BLOCK_SIZE);
        int entranceRow = n-1;
        int exitRow = rand.nextInt(utils.game.settings.getMazeSize());

        maze = new CubeMaze(utils.game.settings.getMazeSize(), mazeCoordinates, utils, entranceRow, exitRow);

        Vector2 endPlatformCoordinates = new Vector2(maze.getEndX(), maze.getExitY());
        endPlatform = new Platform(endPlatformCoordinates, (int)(screenWidth /Constants.BLOCK_SIZE /4), Directions.RIGHT, utils);
        endPlatform.addMiddleSensor();
    }

    public void updatePosition() {
        startPlatform.updatePosition();
        maze.updatePosition();
        endPlatform.updatePosition();
    }

    public void draw() {
        startPlatform.draw();
        maze.draw();
        endPlatform.draw();
    }

    public void dispose() {
        startPlatform.dispose();
        maze.dispose();
        endPlatform.dispose();
    }
}
