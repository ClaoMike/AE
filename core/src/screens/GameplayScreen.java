package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.physics.box2d.*;
import cameras.FollowingCamera;
import dev.clao.GameMain;
import helpers.GameInfo;
import objects.gameplay.player.MainPlayer;
import objects.gameplay.player.PlayerAction;
import objects.gameplay.player.PlayerContactListener;
import objects.gameplay.terrain.WorldTerrainGenerator;
import screens.blueprints.BasicScreen;
import screens.blueprints.BasicScreenMethods;

public class GameplayScreen extends BasicScreen implements BasicScreenMethods {
    private final World world;
    private final MainPlayer player;
    private final FollowingCamera camera;
    private final WorldTerrainGenerator terrainGenerator;

    public GameplayScreen(GameMain game) {
        super(game);
        this.world = new World(GameInfo.GRAVITY, GameInfo.WORLD_DO_SLEEP);

        player = new MainPlayer(GameInfo.PLAYER, GameInfo.WIDTH/2f, GameInfo.HEIGHT/2f, world, BodyDef.BodyType.DynamicBody, 1.0f);
        terrainGenerator = new WorldTerrainGenerator(spriteBatch, world);

        camera = new FollowingCamera(spriteBatch, world, GameInfo.WIDTH, GameInfo.HEIGHT, player);
    }

    @Override
    public void show() {
        world.setContactListener(new PlayerContactListener(player));
    }

    @Override
    public void renderBeforDrawing() {
        world.step(Gdx.graphics.getDeltaTime(), GameInfo.VELOCITY_ITERATIONS, GameInfo.POSITION_ITERATIONS);

        detectUserInput();

        player.updatePosition();
        terrainGenerator.updatePosition();

        camera.update();
    }

    @Override
    public void renderWhileDrawing() {
        player.draw(spriteBatch);
        terrainGenerator.draw();
    }

    @Override
    public void renderAfterDrawing() {
        camera.render();
    }

    @Override
    public void disposeItems() {
        world.dispose();
        camera.dispose();
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

}
