package refactor.screens.gameplay;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

import dev.clao.GameMain;
import refactor.cameras.FollowingCamera;
import refactor.objects.Directions;
import refactor.objects.blocks.CubeMaze;
import refactor.objects.blocks.cube.Cube;
import refactor.objects.blocks.cube.CubeArrangements;
import refactor.objects.blocks.platforms.Platform;
import refactor.objects.maze.Maze;
import refactor.objects.player.Player;
import refactor.objects.spaceship.Spaceship;
import refactor.screens.blueprints.SimpleScreen;

import java.util.Random;

public class GameplayScreen extends SimpleScreen {
    private final GameUtils utils;
    private final World world;
    private final FollowingCamera camera;
    private final Spaceship spaceship;
    private final Player player;
    private Platform platform;
    private CubeMaze maze;


    public GameplayScreen(GameMain game) {
        super(game);

        // world, utils, camera
        world = new World(new Vector2(0, 0), true);
        utils = new GameUtils(game, world);
        camera = new FollowingCamera(utils);

        //terrain
        float screenWidth = Gdx.graphics.getWidth();
        Vector2 coordinates = new Vector2(-screenWidth/2-400, 150);

        platform = new Platform(coordinates, (int)(screenWidth/100/4), Directions.LEFT, utils);
        Random rand = new Random();
        int n = rand.nextInt(game.settings.getMazeSize()) + 1;
        Vector2 mazeCoordinates = new Vector2(platform.getEndX(), 150 + n * 400);

        int entranceRow = n-1;
        int exitRow = rand.nextInt(game.settings.getMazeSize());

        maze = new CubeMaze(game.settings.getMazeSize(), mazeCoordinates, utils, entranceRow, exitRow);

        // spaceship
        spaceship = new Spaceship(utils, -300, 0);

        //player
        player = new Player(utils);

        //TODO:
        // 2. Generate the maze, draw it;
        // 3. Draw the finish platform;
        // 4. Draw some kind of reward in the end room;
        // 5. Add sensors for detecting when the player reaches the end platform;
        // 6. Show an end menu when the sensors are triggered.
    }

    @Override
    public void show() {
    }

    private void updatePositions() {
        // terrain
        platform.updatePosition();
        maze.updatePosition();

        // spaceship
        spaceship.updatePosition();

        // player
        player.updatePosition();
    }

    private void draw() {
        // terrain
        platform.draw();
        maze.draw();

        // spaceship
        spaceship.draw();

        // player
        player.draw();
    }

    @Override
    public void render(float delta) {
        // Clear screen
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Update the world by making a step
        world.step(Gdx.graphics.getDeltaTime(),getConstants().VELOCITY_ITERATIONS, getConstants().POSITION_ITERATIONS);
        camera.setProjection();

        // Detect user input
        detectUserInput();

        // Update position of sprites based on their bodies
        updatePositions();

        // Draw the sprites
        getBatch().begin();
        draw();
        getBatch().end();

        // Update cameras
        camera.followSpriteAndBodyOf(player.getSprite());
    }

    private void detectUserInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            // TODO:
            //  1. Implement a pause menu;
            //  2. Stop every movement when the menu is on
            System.out.println("ESCAPE");
        }
    }

    @Override
    public void resize(int width, int height) {
        camera.resize(width, height);
    }

    @Override
    public void dispose() {
    }
}