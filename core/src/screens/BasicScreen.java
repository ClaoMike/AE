package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.*;
import cameras.FollowingCamera;
import dev.clao.GameMain;
import helpers.GameInfo;
import objects.DrawableMaze;
import objects.MainPlayer;
import objects.Maze;
import objects.PlayerAction;
import objects.WorldTerrainGenerator;

public class BasicScreen implements Screen {
    private final GameMain game;
    private final World world;
    private final SpriteBatch spriteBatch;
    private MainPlayer player;
    private final FollowingCamera camera;
    private WorldTerrainGenerator terrainGenerator;

    public BasicScreen(GameMain game, boolean debugMode) {
        this.game = game;
        this.spriteBatch = game.getBatch();
        this.world = new World(GameInfo.GRAVITY, GameInfo.WORLD_DO_SLEEP);

        player = new MainPlayer(GameInfo.PLAYER, GameInfo.WIDTH/2, GameInfo.HEIGHT/2, world, BodyDef.BodyType.DynamicBody, 1.0f);
        terrainGenerator = new WorldTerrainGenerator(spriteBatch, world);

        camera = new FollowingCamera(spriteBatch, world, GameInfo.WIDTH, GameInfo.HEIGHT, player);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        world.step(Gdx.graphics.getDeltaTime(), GameInfo.VELOCITY_ITERATIONS, GameInfo.POSITION_ITERATIONS);

        detectUserInput();

        player.updatePosition();
        terrainGenerator.updatePosition();

        camera.update();

        spriteBatch.begin();
        player.draw(spriteBatch);
        terrainGenerator.draw();
        spriteBatch.end();

        camera.render();
    }

    @Override
    public void dispose() {
        world.dispose();
        camera.dispose();
        spriteBatch.dispose();
        player.dispose();
        terrainGenerator.dispose();
    }

    private void detectUserInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            player.performAction(PlayerAction.GO_LEFT);
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            player.performAction(PlayerAction.GO_RIGHT);
        } else if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            player.performAction(PlayerAction.GO_UP);
        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            player.performAction(PlayerAction.GO_DOWN);
        }
    }

    @Override
    public void show() {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

}
