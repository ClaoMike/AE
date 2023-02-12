package cameras;

import static helpers.GameInfo.PPM;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import objects.AtomicObject;

public class FollowingCamera {
    private OrthographicCamera camera;
    private Box2DDebugRenderer debugRenderer;
    private SpriteBatch batch;
    private World world;
    private boolean isDebug;
    private AtomicObject following;

    public FollowingCamera(SpriteBatch batch, World world, float w, float h, boolean isDebug, AtomicObject following) {
        this.isDebug = isDebug;
        this.world = world;
        this.batch = batch;
        this.following = following;

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

    private void updatePosition() {
        if (isDebug) {
            updatePosition(following.getBody().getPosition().x, following.getBody().getPosition().y);
        } else {
            updatePosition(following.getX() + following.getWidth() / 2, following.getY() + following.getHeight() / 2);
        }
    }

    public void update() {
        updatePosition();
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
