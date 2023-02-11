package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import dev.clao.GameMain;
import helpers.GameInfo;

public class BasicScreen implements Screen {
    protected GameMain game;
    private OrthographicCamera camera;
    private ExtendViewport viewport;
    protected World world;
    private Box2DDebugRenderer debugRenderer;
    private float accumulator = 0;

    public BasicScreen(GameMain game) {
        this.game = game;
    }

    private void stepWorld() {
        float delta = Gdx.graphics.getDeltaTime();

        accumulator += Math.min(delta, 0.25f);

        if (accumulator >= GameInfo.STEP_TIME) {
            accumulator -= GameInfo.STEP_TIME;

            world.step(GameInfo.STEP_TIME, GameInfo.VELOCITY_ITERATIONS, GameInfo.POSITION_ITERATIONS);
        }
    }

    @Override
    public void show() {
        Box2D.init();
        world = new World(new Vector2(0, -GameInfo.GRAVITY), true);

        camera = new OrthographicCamera();
        viewport = new ExtendViewport(GameInfo.WIDTH*2/GameInfo.PPM, GameInfo.HEIGHT*2/GameInfo.PPM, camera);
        debugRenderer = new Box2DDebugRenderer();

        showObjects();
    }

    protected void showObjects() {

    }

    @Override
    public void render(float delta) {
        stepWorld();

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.getBatch().begin();
        drawObjects();
        game.getBatch().end();

        updateCamera(getCameraNewPosition());

        debugRenderer.render(world, camera.combined);
    }

    private void updateCamera(Vector3 newPosition) {
        camera.position.set(newPosition);
        camera.update();
    }
    protected Vector3 getCameraNewPosition() {
        return new Vector3(0,0,0);
    }

    protected void drawObjects() {

    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
        game.getBatch().setProjectionMatrix(camera.combined);
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
        world.dispose();
        debugRenderer.dispose();
    }
}
