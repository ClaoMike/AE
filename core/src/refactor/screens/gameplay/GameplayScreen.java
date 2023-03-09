package refactor.screens.gameplay;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

import dev.clao.GameMain;
import helpers.GameInfo;
import refactor.objects.blueprints.Atom;
import refactor.objects.blocks.Block;
import refactor.cameras.FollowingCamera;
import refactor.objects.player.Player;
import refactor.screens.blueprints.SimpleScreen;

public class GameplayScreen extends SimpleScreen {
    private final World world;
    private final FollowingCamera camera;
    private final Player player;
    private final Block blockOfSnow;
    private final Atom spaceship;

    public GameplayScreen(GameMain game) {
        super(game);

        world = new World(new Vector2(0, 0), true);
        camera = new FollowingCamera(game, world);

        blockOfSnow = new Block(game, getConstants().BLOCK_IMAGE_FILEPATH, world, 300, 300, false);

        player = new Player(game, world);

        float spaceshipX = player.getSprite().getX() - 2 * player.getSprite().getWidth();
        float spaceshipY = player.getSprite().getY() + player.getSprite().getHeight() /2;

        spaceship = new Atom(
                game,
                "refactor/images/spaceship.png",
                world,
                BodyDef.BodyType.StaticBody,
                spaceshipX,
                spaceshipY,
                1,
                false
        );

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
        spaceship.updatePosition();

        // Draw the sprites
        getBatch().begin();
        player.draw();
        blockOfSnow.draw();
        spaceship.draw();
        getBatch().end();

        // Update cameras
        camera.followSpriteAndBodyOf(player.getSprite());
    }

    private void detectUserInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            System.out.println("ESCAPE"); // TODO: implement this, show a menu
        }
    }

    @Override
    public void resize(int width, int height) {
        camera.resize(width, height);
    }

}