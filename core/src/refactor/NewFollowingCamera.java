package refactor;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

import dev.clao.GameMain;

public class NewFollowingCamera {
    private GameMain game;
    private SpriteBatch batch;
    private World world;
    private OrthographicCamera mainCamera;
    private OrthographicCamera debugCamera;
    private Box2DDebugRenderer debugRenderer;

    public NewFollowingCamera(GameMain game, SpriteBatch batch, World world) {
        this.game = game;
        this.batch = batch;
        this.world = world;

        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();

        mainCamera = new OrthographicCamera();
        mainCamera.setToOrtho(false, screenWidth, screenHeight);

        debugCamera = new OrthographicCamera();
        debugCamera.setToOrtho(false, screenWidth / game.getConstants().PPM, screenHeight / game.getConstants().PPM);

        debugRenderer = new Box2DDebugRenderer();
    }

    public void setProjection() {
        batch.setProjectionMatrix(mainCamera.combined);
    }

    public void followSprite(Sprite sprite) {
        mainCamera.position.set(sprite.getX() + sprite.getWidth()/2, sprite.getY() + sprite.getHeight()/2, 0);
        mainCamera.update();
    }

    public void followBody(Body body) {
        debugCamera.position.set(body.getPosition().x, body.getPosition().y, 0);
        debugRenderer.render(world, debugCamera.combined);
        debugCamera.update();
    }

    public void resize(int width, int height) {
        mainCamera.viewportWidth = width;
        mainCamera.viewportHeight = height;
        mainCamera.update();

        debugCamera.viewportWidth = width / game.getConstants().PPM ;
        debugCamera.viewportHeight = height / game.getConstants().PPM ;
        debugCamera.update();
    }

}