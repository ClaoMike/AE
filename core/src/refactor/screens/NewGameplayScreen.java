package refactor.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

import dev.clao.GameMain;
import helpers.GameInfo;
import refactor.NewFollowingCamera;
import refactor.objects.Atom;
import refactor.screens.blueprints.SimpleScreen;

public class NewGameplayScreen extends SimpleScreen {
    private World world;
    private NewFollowingCamera camera;
    private Atom player;
    private Atom blockOfSnow;

    public NewGameplayScreen(GameMain game) {
        super(game);

        world = new World(new Vector2(0, -9.81f), true);
        camera = new NewFollowingCamera(game, world);

        blockOfSnow = new Atom(
                game,
                "snow.png",
                world,
                BodyDef.BodyType.StaticBody,
                300,
                300,
                1,
                false
        );

        player = new Atom(
                game,
                "player.png",
                world,
                BodyDef.BodyType.DynamicBody,
                0,
                0,
                1,
                false
        );

    }

    @Override
    public void show() {}

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        world.step(Gdx.graphics.getDeltaTime(), GameInfo.VELOCITY_ITERATIONS, GameInfo.POSITION_ITERATIONS);
        camera.setProjection();

        player.updatePosition();
        blockOfSnow.updatePosition();

        getBatch().begin();

        player.draw();
        blockOfSnow.draw();

        getBatch().end();

        camera.followSpriteAndBodyOf(player.getSprite());
    }

    @Override
    public void resize(int width, int height) {
        camera.resize(width, height);
    }

}