package scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import dev.clao.GameMain;
import helpers.GameInfo;

public class BasicScene implements Screen {
    private GameMain game;

    OrthographicCamera camera;
    ExtendViewport viewport;
    Box2DDebugRenderer debugRenderer;

    World world;

    float accumulator = 0;

    private void stepWorld() {
        float delta = Gdx.graphics.getDeltaTime();

        accumulator += Math.min(delta, 0.25f);

        if (accumulator >= GameInfo.STEP_TIME) {
            accumulator -= GameInfo.STEP_TIME;

            world.step(GameInfo.STEP_TIME, GameInfo.VELOCITY_ITERATIONS, GameInfo.POSITION_ITERATIONS);
        }
    }

    public BasicScene(GameMain game) {
        this.game = game;
    }

    @Override
    public void show() {
        Box2D.init();
        world = new World(new Vector2(0, -10), true);

        camera = new OrthographicCamera();
        viewport = new ExtendViewport(GameInfo.WIDTH/GameInfo.PPM, GameInfo.HEIGHT/GameInfo.PPM, camera);
        debugRenderer = new Box2DDebugRenderer();
    }

    @Override
    public void render(float delta) {
        stepWorld();

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.getBatch().begin();
        drawObjects();
        game.getBatch().end();

        debugRenderer.render(world, camera.combined);
    }

    public void drawObjects() {

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
