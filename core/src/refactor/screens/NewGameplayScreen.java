package refactor.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;

import dev.clao.GameMain;
import helpers.GameInfo;
import refactor.objects.CustomSprite;
import refactor.objects.CustomSpriteWithBody;
import refactor.objects.ObjectUserData;
import refactor.screens.blueprints.SimpleScreen;

public class NewGameplayScreen extends SimpleScreen {

    private CustomSpriteWithBody player;
    private CustomSprite blockOfSnow;

    World world;
    OrthographicCamera debugCamera = new OrthographicCamera();
    Box2DDebugRenderer debugRenderer;

    public NewGameplayScreen(GameMain game) {
        super(game);

        world = new World(new Vector2(0, -9.81f), true);

        blockOfSnow = new CustomSprite("snow.png");

        ObjectUserData playerUserData = new ObjectUserData("player");
        Body playerBody = CustomSpriteWithBody.generateBody(world, BodyDef.BodyType.DynamicBody, 0, 0, playerUserData);
        player = new CustomSpriteWithBody("player.png", playerBody);
        player.generatePolygonShape();

        FixtureDef fixtureDef = CustomSpriteWithBody.generateFixtureDef(player.getShape(), 1, false);

        player.attachFixture(fixtureDef);
        player.updatePositionToBody();
    }

    @Override
    public void show() {
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();

        mainCamera = new OrthographicCamera();
        mainCamera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        mainCamera.position.set(mainCamera.viewportWidth / 2f, mainCamera.viewportHeight / 2f, 0);
        mainCamera.update();

        debugCamera.setToOrtho(false, screenWidth/ GameInfo.PPM  , screenHeight/ GameInfo.PPM);

        debugRenderer = new Box2DDebugRenderer();

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        world.step(Gdx.graphics.getDeltaTime(), GameInfo.VELOCITY_ITERATIONS, GameInfo.POSITION_ITERATIONS);

        getBatch().setProjectionMatrix(mainCamera.combined);
        player.updatePositionToBody();

        getBatch().begin();

        getBatch().draw(player, player.getX(), player.getY());
        getBatch().draw(blockOfSnow, 300, 300);

        getBatch().end();

        makeCameraFollowPlayer(mainCamera, player);
        debugCamera.position.set(player.getBody().getPosition().x, player.getBody().getPosition().y, 0);
        mainCamera.update();
        debugRenderer.render(world, debugCamera.combined);
        debugCamera.update();
    }

    @Override
    public void resize(int width, int height) {
        mainCamera.viewportWidth = width;
        mainCamera.viewportHeight = height;
        mainCamera.update();
    }

    private void makeCameraFollowPlayer(OrthographicCamera camera, Sprite player) {
        camera.position.set(player.getX() + player.getWidth()/2, player.getY() + player.getHeight()/2, 0);
    }

}