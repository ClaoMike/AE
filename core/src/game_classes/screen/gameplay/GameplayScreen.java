package game_classes.screen.gameplay;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

import dev.clao.GameMain;
import game_classes.camera.FollowingCamera;
import game_classes.object.terrain.Terrain;
import game_classes.object.player.Player;
import game_classes.object.spaceship.Spaceship;
import game_classes.screen.blueprint.SimpleScreen;

public class GameplayScreen extends SimpleScreen {
    private final World world;
    private final FollowingCamera camera;
    private final Terrain terrain;
    private final Spaceship spaceship;
    private final Player player;

    public GameplayScreen(GameMain game) {
        super(game);

        Vector2 originCoordinates = new Vector2(0, 0);
        Vector2 worldForces = originCoordinates.cpy();

        world = new World(worldForces, true);
        GameUtils utils = new GameUtils(game, world);

        //camera
        camera = new FollowingCamera(utils);
        //terrain
        terrain = new Terrain(utils, new Vector2(0, 0));
        // spaceship
        spaceship = new Spaceship(utils, -300, 0);
        //player
        player = new Player(utils);

        //TODO:
        // 1. Sensor for reaching the end;
        // 2. Stop movement when sensor is touched;
        // 3. Draw a satellite/rover;
        // 4. Draw some kind of reward in the end room;
        // 5. Add sensors for detecting when the player reaches the end platform;
        // 6. Show an end menu when the sensors are triggered.
    }

    @Override
    public void show() {
    }

    private void updatePositions() {
        // terrain
        terrain.updatePosition();
        // spaceship
        spaceship.updatePosition();
        // player
        player.updatePosition();
    }

    private void draw() {
        // terrain
        terrain.draw();
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
        terrain.dispose();
        spaceship.dispose();
        player.dispose();
    }
}