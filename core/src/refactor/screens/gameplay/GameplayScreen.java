package refactor.screens.gameplay;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

import dev.clao.GameMain;
import refactor.cameras.FollowingCamera;
import refactor.objects.Directions;
import refactor.objects.blocks.BlockTypes;
import refactor.objects.blocks.cube.CubeArrangements;
import refactor.objects.blocks.cube.Cube;
import refactor.objects.blocks.platforms.Platform;
import refactor.objects.player.Player;
import refactor.screens.blueprints.SimpleScreen;

public class GameplayScreen extends SimpleScreen {
    private final World world;
    private final FollowingCamera camera;
    private final Player player;

    private Platform platform;


    public GameplayScreen(GameMain game) {
        super(game);

        world = new World(new Vector2(0, 0), true);
        camera = new FollowingCamera(game, world);

        player = new Player(game, world);

        GameUtils utils = new GameUtils(game, world);

        float screenWidth = Gdx.graphics.getWidth();
        Vector2 coordinates = new Vector2(-screenWidth/2, 150);

        platform = new Platform(coordinates, (int)(screenWidth/100/4), Directions.LEFT, utils);

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
        player.updatePosition();

        platform.updatePosition();

        // Draw the sprites
        getBatch().begin();

        // terrain
        platform.draw();

        //player
        player.draw();

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