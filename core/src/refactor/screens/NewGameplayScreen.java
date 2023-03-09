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
import refactor.NewFollowingCamera;
import refactor.objects.CustomSpriteWithBody;
import refactor.objects.ObjectUserData;
import refactor.screens.blueprints.SimpleScreen;

public class NewGameplayScreen extends SimpleScreen {
    private World world;
    private NewFollowingCamera camera;
    private CustomSpriteWithBody player;
    private CustomSpriteWithBody blockOfSnow;

    public NewGameplayScreen(GameMain game) {
        super(game);

        world = new World(new Vector2(0, 0), true);
        camera = new NewFollowingCamera(game, world);

        ////////////////////////////////////////////////////////////////////////////////////////////
        ObjectUserData blockOfSnowUserData = new ObjectUserData("snow");
        Body blockOfSnowBody = CustomSpriteWithBody.generateBody(world, BodyDef.BodyType.StaticBody, 300, 300, blockOfSnowUserData);
        blockOfSnow = new CustomSpriteWithBody("snow.png", blockOfSnowBody);
        blockOfSnow.generatePolygonShape();

        FixtureDef blockOfSnowFixtureDef = CustomSpriteWithBody.generateFixtureDef(blockOfSnow.getShape(), 1, false);

        blockOfSnow.attachFixture(blockOfSnowFixtureDef );
        blockOfSnow.updatePositionToBody();

        ////////////////////////////////////////////////////////////////////////////////////////////
        ObjectUserData playerUserData = new ObjectUserData("player");
        Body playerBody = CustomSpriteWithBody.generateBody(world, BodyDef.BodyType.DynamicBody, 0, 0, playerUserData);
        player = new CustomSpriteWithBody("player.png", playerBody);
        player.generatePolygonShape();

        FixtureDef playerFixtureDef = CustomSpriteWithBody.generateFixtureDef(player.getShape(), 1, false);

        player.attachFixture(playerFixtureDef);
        player.updatePositionToBody();
        ////////////////////////////////////////////////////////////////////////////////////////////
    }

    @Override
    public void show() {}

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        world.step(Gdx.graphics.getDeltaTime(), GameInfo.VELOCITY_ITERATIONS, GameInfo.POSITION_ITERATIONS);
        camera.setProjection();

        player.updatePositionToBody();
        blockOfSnow.updatePositionToBody();

        getBatch().begin();

        getBatch().draw(player, player.getX(), player.getY());
        getBatch().draw(blockOfSnow, blockOfSnow.getX(), blockOfSnow.getY());

        getBatch().end();

        camera.followSpriteAndBodyOf(player);
    }

    @Override
    public void resize(int width, int height) {
        camera.resize(width, height);
    }

}