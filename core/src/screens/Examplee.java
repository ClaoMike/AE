package screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

public class Examplee implements Screen {
    private World world;
    private Box2DDebugRenderer debugRenderer;
    private SpriteBatch spriteBatch;
    private Sprite sprite, staticSprite;
    private Body body, body2;
    private OrthographicCamera camera;
    private final float PPM = 100f;

    @Override
    public void show() {
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        world = new World(new Vector2(0, -10), true);
        debugRenderer = new Box2DDebugRenderer();
        spriteBatch = new SpriteBatch();
        sprite = new Sprite(new Texture(Gdx.files.internal("player.png")));
        staticSprite = new Sprite(new Texture(Gdx.files.internal("player.png")));
        // TODO:
        // normal camera
        camera = new OrthographicCamera(w, h);
        // rendering camera
//        camera = new OrthographicCamera(W/PPM, H/PPM);
        camera.position.set(w / 2, h / 2, 0);

        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(w / 2 / PPM, h / 2/ PPM);
        body = world.createBody(bodyDef);

        BodyDef bodyDef2 = new BodyDef();
        bodyDef2.type = BodyDef.BodyType.StaticBody;
        bodyDef2.position.set(w / 3/ PPM, h / 3/ PPM);
        body2 = world.createBody(bodyDef2);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(sprite.getWidth() / 2/ PPM, sprite.getHeight() / 2/ PPM);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1.0f;

        body.createFixture(fixtureDef);
        body2.createFixture(fixtureDef);
        shape.dispose();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        world.step(Gdx.graphics.getDeltaTime(), 6, 2);
        sprite.setPosition((body.getPosition().x - sprite.getWidth() / 2) * PPM, (body.getPosition().y - sprite.getHeight() / 2) * PPM);
        sprite.setRotation((float)Math.toDegrees(body.getAngle()));
        staticSprite.setPosition((body2.getPosition().x - staticSprite.getWidth() / 2) * PPM, (body2.getPosition().y - staticSprite.getHeight() / 2) * PPM);
        staticSprite.setRotation((float)Math.toDegrees(body2.getAngle()));

        // TODO:
        // normal camera
        camera.position.set(sprite.getX() + sprite.getWidth() / 2, sprite.getY() + sprite.getHeight() / 2, 0);
        // rendering camera
//        camera.position.set(body.getPosition().x, body.getPosition().y, 0);

        camera.update();
        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        sprite.draw(spriteBatch);
        staticSprite.draw(spriteBatch);
        spriteBatch.end();
        debugRenderer.render(world, spriteBatch.getProjectionMatrix());
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
        world.dispose();
        debugRenderer.dispose();
        spriteBatch.dispose();
        sprite.getTexture().dispose();
    }

}
