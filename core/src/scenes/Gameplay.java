package scenes;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import dev.clao.GameMain;
import gameObjects.staticObjects.WorldTerrainController;
import helpers.GameInfo;

public class Gameplay implements Screen {
    private GameMain game;

    private OrthographicCamera mainCamera;
    private Viewport viewport;

    private OrthographicCamera renderCamera;
    private Box2DDebugRenderer debugRenderer;

    private World world;

    private WorldTerrainController worldTerrainController;

    public Gameplay(GameMain game) {
        this.game = game;

        mainCamera = new OrthographicCamera(GameInfo.WIDTH, GameInfo.HEIGHT);
        mainCamera.position.set(GameInfo.WIDTH/2, GameInfo.HEIGHT/2, 0);
        viewport = new StretchViewport(GameInfo.WIDTH, GameInfo.HEIGHT, mainCamera);

        renderCamera = new OrthographicCamera();
        renderCamera.setToOrtho(false, GameInfo.WIDTH, GameInfo.HEIGHT);
        renderCamera.position.set(GameInfo.WIDTH/2, GameInfo.HEIGHT/2, 0);
        debugRenderer = new Box2DDebugRenderer();

        world = new World(new Vector2(0, -9.8f), true);

        worldTerrainController = new WorldTerrainController(game, world);

    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 1, 1);

        game.getBatch().begin();

        worldTerrainController.drawTerrain();

        game.getBatch().end();

        debugRenderer.render(world, renderCamera.combined);
        game.getBatch().setProjectionMatrix(mainCamera.combined);
        mainCamera.update();
//        renderCamera.update();
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

    @Override
    public void dispose() {

    }
}
