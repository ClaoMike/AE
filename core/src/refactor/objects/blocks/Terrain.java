package refactor.objects.blocks;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

import refactor.objects.Directions;
import refactor.objects.blocks.platforms.Platform;
import refactor.screens.gameplay.GameUtils;

public class Terrain {
    private final Platform startPlatform;
    private final CubeMaze maze;
    private final Platform endPlatform;

    public Terrain(GameUtils utils) {
        float screenWidth = Gdx.graphics.getWidth();
        Vector2 coordinates = new Vector2(-screenWidth/2-400, 150);

        startPlatform = new Platform(coordinates, (int)(screenWidth/100/4), Directions.LEFT, utils);

        Random rand = new Random();
        int n = rand.nextInt(utils.game.settings.getMazeSize()) + 1;
        Vector2 mazeCoordinates = new Vector2(startPlatform.getEndX(), 150 + n * 400);
        int entranceRow = n-1;
        int exitRow = rand.nextInt(utils.game.settings.getMazeSize());

        maze = new CubeMaze(utils.game.settings.getMazeSize(), mazeCoordinates, utils, entranceRow, exitRow);

        Vector2 endPlatformCoordinates = new Vector2(maze.getEndX(), maze.getExitY());
        endPlatform = new Platform(endPlatformCoordinates, (int)(screenWidth/100/4), Directions.RIGHT, utils);
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
