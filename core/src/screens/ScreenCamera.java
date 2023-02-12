package screens;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import dev.clao.GameMain;
import helpers.GameInfo;

public class ScreenCamera {
    private OrthographicCamera mainCamera;
    private Viewport viewport;
    private OrthographicCamera box2DCamera;
    private Box2DDebugRenderer debugRenderer;

    private World world;
    private Vector3 position;
    private GameMain game;

    public ScreenCamera(GameMain game, World world) {
        this.game = game;
        this.world = world;
        position = new Vector3(GameInfo.WIDTH/2, GameInfo.HEIGHT/2,0);

        mainCamera = new OrthographicCamera(GameInfo.WIDTH, GameInfo.HEIGHT);
        mainCamera.position.set(GameInfo.WIDTH / 2f, GameInfo.HEIGHT / 2, 0);

        viewport = new StretchViewport(GameInfo.WIDTH, GameInfo.HEIGHT,
                mainCamera);

        box2DCamera = new OrthographicCamera();
        box2DCamera.setToOrtho(false, GameInfo.WIDTH / GameInfo.PPM,
                GameInfo.HEIGHT / GameInfo.PPM);
        box2DCamera.position.set(GameInfo.WIDTH / 2f, GameInfo.HEIGHT/ 2f, 0);

        debugRenderer = new Box2DDebugRenderer();

    }

    public void update() {
        mainCamera.position.set(position);
        box2DCamera.position.set(position);

        debugRenderer.render(world, box2DCamera.combined);

        game.getBatch().setProjectionMatrix(mainCamera.combined);
        mainCamera.update();
        box2DCamera.update();
    }

    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    public void dispose() {
        debugRenderer.dispose();
    }

    public void updatePosition(Vector3 position) {
        this.position = position;
    }
}
