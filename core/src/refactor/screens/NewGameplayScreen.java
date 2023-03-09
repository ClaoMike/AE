package refactor.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

import dev.clao.GameMain;
import helpers.GameInfo;
import refactor.Block;
import refactor.NewFollowingCamera;
import refactor.Player;
import refactor.screens.blueprints.SimpleScreen;

public class NewGameplayScreen extends SimpleScreen {
    private final World world;
    private final NewFollowingCamera camera;
    private final Player player;
    private final Block blockOfSnow;

    public NewGameplayScreen(GameMain game) {
        super(game);

        world = new World(new Vector2(0, 0), true);
        camera = new NewFollowingCamera(game, world);

        blockOfSnow = new Block(game, getConstants().BLOCK_IMAGE_FILEPATH, world, 300, 300, false);

        player = new Player(game, world);

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
        world.step(Gdx.graphics.getDeltaTime(), GameInfo.VELOCITY_ITERATIONS, GameInfo.POSITION_ITERATIONS);
        camera.setProjection();

        // Detect user input
        detectUserInput();

        // Update position of sprites based on their bodies
        player.updatePosition();
        blockOfSnow.updatePosition();

        // Draw the sprites
        getBatch().begin();
        player.draw();
        blockOfSnow.draw();
        getBatch().end();

        // Update cameras
        camera.followSpriteAndBodyOf(player.getSprite());
    }

    private void detectUserInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            System.out.println("A"); // TODO: implement this
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            System.out.println("D"); // TODO: implement this
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            System.out.println("W");  // TODO: implement this
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            System.out.println("S"); // TODO: implement this
        }
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            System.out.println("ESCAPE"); // TODO: implement this
        }
    }

    @Override
    public void resize(int width, int height) {
        camera.resize(width, height);
    }

}