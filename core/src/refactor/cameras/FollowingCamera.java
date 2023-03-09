package refactor.cameras;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

import dev.clao.GameMain;
import refactor.objects.blueprints.CustomSpriteWithBody;

public class FollowingCamera {
    private final GameMain game;
    private final World world;
    private final OrthographicCamera mainCamera;
    private OrthographicCamera debugCamera;
    private Box2DDebugRenderer debugRenderer;
    private final boolean debugModeIsOn;

    public FollowingCamera(GameMain game, World world) {
        this.game = game;
        this.world = world;
        this.debugModeIsOn = game.settings.getDebugMode();

        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();

        mainCamera = new OrthographicCamera();
        mainCamera.setToOrtho(false, screenWidth, screenHeight);

        if(debugModeIsOn) {
            debugCamera = new OrthographicCamera();
            debugCamera.setToOrtho(false, screenWidth / game.getConstants().PPM, screenHeight / game.getConstants().PPM);

            debugRenderer = new Box2DDebugRenderer();
        }
    }

    public void setProjection() {
        game.getBatch().setProjectionMatrix(mainCamera.combined);
    }

    public void followSpriteAndBodyOf(CustomSpriteWithBody sprite) {
        followSprite(sprite);
        if(debugModeIsOn) {
            followBody(sprite.getBody());
        }
    }

    private void followBody(Body body) {
        debugCamera.position.set(body.getPosition().x, body.getPosition().y, 0);
        debugRenderer.render(world, debugCamera.combined);
        debugCamera.update();
    }

    private void followSprite(Sprite sprite) {
        mainCamera.position.set(sprite.getX() + sprite.getWidth()/2, sprite.getY() + sprite.getHeight()/2, 0);
        mainCamera.update();
    }

    public void resize(int width, int height) {
        mainCamera.viewportWidth = width;
        mainCamera.viewportHeight = height;
        mainCamera.update();

        if(debugModeIsOn) {
            debugCamera.viewportWidth = width / game.getConstants().PPM ;
            debugCamera.viewportHeight = height / game.getConstants().PPM ;
            debugCamera.update();
        }
    }

}
