package refactor.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

import dev.clao.GameMain;
import helpers.GameInfo;
import refactor.screens.blueprints.SimpleScreen;
import refactor.screens.uicomponents.BackgroundImage;
import refactor.screens.uicomponents.CustomFont;

public class NewGameplayScreen extends SimpleScreen {

    private Sprite player;
    private Sprite blockOfSnow;

    World world;
    OrthographicCamera debugCamera = new OrthographicCamera();
    Box2DDebugRenderer debugRenderer;


    public NewGameplayScreen(GameMain game) {
        super(game);

        player = new Sprite(new Texture("player.png"));
        blockOfSnow = new Sprite(new Texture("snow.png"));

        player.setPosition(0-player.getWidth()/2, 0-player.getHeight()/2);

        world = new World(new Vector2(0, 0), true);

        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(player.getX() / GameInfo.PPM, player.getY() / GameInfo.PPM);

        Body body = world.createBody(bodyDef);
        body.setUserData("player");

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(player.getWidth() / 2 / GameInfo.PPM, player.getHeight() / 2 / GameInfo.PPM);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1;
        fixtureDef.isSensor = false;

        body.createFixture(fixtureDef);
        shape.dispose();
    }

    @Override
    public void show() {
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();

        mainCamera = new OrthographicCamera();
        mainCamera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        mainCamera.position.set(mainCamera.viewportWidth / 2f, mainCamera.viewportHeight / 2f, 0);
        mainCamera.update();

        debugCamera.setToOrtho(false, screenWidth , screenHeight);
        debugCamera.position.set(mainCamera.position);
        debugCamera.zoom = mainCamera.zoom;

        debugRenderer = new Box2DDebugRenderer();

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        getBatch().setProjectionMatrix(mainCamera.combined);
//        updatePlayerPositionTest();

        getBatch().begin();

        getBatch().draw(player, player.getX(), player.getY());
        getBatch().draw(blockOfSnow, 300, 300);

        getBatch().end();

        makeCameraFollowPlayer(mainCamera, player);
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

    private void updatePlayerPositionTest() {
        player.setPosition(player.getX()+1, player.getY());
    }

}
