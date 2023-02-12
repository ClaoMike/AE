package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.*;
import cameras.FollowingCamera;
import dev.clao.GameMain;
import helpers.GameInfo;
import objects.AtomicObject;

public class BasicScreen implements Screen {
    private final GameMain game;
    private final World world;
    private final SpriteBatch spriteBatch;
    private AtomicObject a1, a2;
    private final FollowingCamera camera;

    public BasicScreen(GameMain game, boolean debugMode) {
        this.game = game;
        this.spriteBatch = game.getBatch();
        this.world = new World(GameInfo.GRAVITY, GameInfo.WORLD_DO_SLEEP);

        //noinspection IntegerDivisionInFloatingPointContext
        a1 = new AtomicObject(
                GameInfo.PLAYER,
                GameInfo.WIDTH/2,
                GameInfo.HEIGHT/2,
                world,
                BodyDef.BodyType.DynamicBody,
                1.0f);
        //noinspection IntegerDivisionInFloatingPointContext
        a2 = new AtomicObject(
                GameInfo.PLAYER,
                GameInfo.WIDTH/3,
                GameInfo.HEIGHT/3,
                world,
                BodyDef.BodyType.StaticBody,
                1.0f);

        camera = new FollowingCamera(spriteBatch, world, GameInfo.WIDTH, GameInfo.HEIGHT, a1);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        world.step(Gdx.graphics.getDeltaTime(), GameInfo.VELOCITY_ITERATIONS, GameInfo.POSITION_ITERATIONS);

        a1.updatePosition();
        a2.updatePosition();

        camera.update();

        spriteBatch.begin();
        a1.draw(spriteBatch);
        a2.draw(spriteBatch);
        spriteBatch.end();

        camera.render();
    }

    @Override
    public void dispose() {
        world.dispose();
        camera.dispose();
        spriteBatch.dispose();
        a1.dispose();
        a2.dispose();
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
