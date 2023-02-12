package screens;

import static helpers.GameInfo.PPM;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

public class ScreenCamera {
    private OrthographicCamera camera;
    private Box2DDebugRenderer debugRenderer;
    private SpriteBatch batch;
    private World world;
    private boolean isDebug;

    public ScreenCamera(SpriteBatch batch, World world, float w, float h, boolean isDebug) {
        this.isDebug = isDebug;
        this.world = world;
        this.batch = batch;

        debugRenderer = new Box2DDebugRenderer();

        if(isDebug) {
            camera = new OrthographicCamera(w/PPM, h/PPM); // rendering camera
        } else {
            camera = new OrthographicCamera(w, h); // normal camera
        }

        camera.position.set(w / 2, h / 2, 0);
    }

    private void updatePosition(float x, float y) {
        camera.position.set(x, y, 0);
    }

    public void updatePosition(Sprite sprite, Body body) {
        if (isDebug) {
            updatePosition(body.getPosition().x, body.getPosition().y);
        } else {
            updatePosition(sprite.getX() + sprite.getWidth() / 2, sprite.getY() + sprite.getHeight() / 2);
        }
    }

    public void update() {
        camera.update();
        batch.setProjectionMatrix(camera.combined);
    }

    public void render() {
        debugRenderer.render(world, batch.getProjectionMatrix());
    }

    public void dispose() {
        debugRenderer.dispose();
    }

}
