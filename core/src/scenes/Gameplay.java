package scenes;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import dev.clao.GameMain;
import helpers.GameInfo;

public class Gameplay implements Screen {
    private GameMain game;
    private Texture img;
    private Sprite cube;

    OrthographicCamera camera;
    ExtendViewport viewport;
    World world;

    static final float STEP_TIME = 1f / 60f;
    static final int VELOCITY_ITERATIONS = 6;
    static final int POSITION_ITERATIONS = 2;

    float accumulator = 0;

    Box2DDebugRenderer debugRenderer;
    Body body;

    private void stepWorld() {
        float delta = Gdx.graphics.getDeltaTime();

        accumulator += Math.min(delta, 0.25f);

        if (accumulator >= STEP_TIME) {
            accumulator -= STEP_TIME;

            world.step(STEP_TIME, VELOCITY_ITERATIONS, POSITION_ITERATIONS);
        }
    }

    public Gameplay(GameMain game) {
        this.game = game;
    }
    @Override
    public void show() {
        Box2D.init();
        world = new World(new Vector2(0, -10), true);

        img = new Texture("groundCube.png");
        cube = new Sprite(img);
        camera = new OrthographicCamera();
        viewport = new ExtendViewport(GameInfo.WIDTH/GameInfo.PPM, GameInfo.HEIGHT/GameInfo.PPM, camera);
        debugRenderer = new Box2DDebugRenderer();

        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
//        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.position.set(1000/GameInfo.PPM , 500/GameInfo.PPM);

// Create our body in the world using our body definition
        body = world.createBody(bodyDef);

// Create a circle shape and set its radius to 6
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(100/GameInfo.PPM, 100/GameInfo.PPM);

// Create a fixture definition to apply our shape to
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 0.5f;
        fixtureDef.friction = 0.4f;
//        fixtureDef.restitution = 0.6f; // Make it bounce a little bit

// Create our fixture and attach it to the body
        Fixture fixture = body.createFixture(fixtureDef);

// Remember to dispose of any shapes after you're done with them!
// BodyDef and FixtureDef don't need disposing, but shapes do.
        shape.dispose();

    }

    @Override
    public void render(float delta) {
        stepWorld();

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.getBatch().begin();

        game.getBatch().draw(cube, body.getPosition().x - cube.getWidth()/GameInfo.PPM, body.getPosition().y - cube.getHeight()/GameInfo.PPM, cube.getWidth()*2/GameInfo.PPM,cube.getHeight()*2/ GameInfo.PPM);

        game.getBatch().end();

        debugRenderer.render(world, camera.combined);
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
        img.dispose();
        world.dispose();
        debugRenderer.dispose();
    }
}
