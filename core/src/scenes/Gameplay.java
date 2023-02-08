package scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import dev.clao.GameMain;
import gameObjects.dynamicObjects.MainPlayer;
import gameObjects.staticObjects.WorldTerrainController;
import helpers.GameInfo;

public class Gameplay implements Screen {
    private GameMain game;

    private OrthographicCamera mainCamera;
    private Viewport viewport;

    private OrthographicCamera renderCamera;
    private Box2DDebugRenderer debugRenderer;

    private World world;

    private WorldTerrainController worldTerrainController;
    private MainPlayer player;

    public Gameplay(GameMain game) {
        this.game = game; 

        mainCamera = new OrthographicCamera(GameInfo.WIDTH, GameInfo.HEIGHT);
        mainCamera.position.set(GameInfo.WIDTH/2, GameInfo.HEIGHT/2, 0);
        viewport = new StretchViewport(GameInfo.WIDTH, GameInfo.HEIGHT, mainCamera);

        renderCamera = new OrthographicCamera();
        renderCamera.setToOrtho(false, GameInfo.WIDTH, GameInfo.HEIGHT);
        renderCamera.position.set(GameInfo.WIDTH/2, GameInfo.HEIGHT/2, 0);
        debugRenderer = new Box2DDebugRenderer();

        world = new World(new Vector2(0, -9.8f), true);

        worldTerrainController = new WorldTerrainController(game, world);
        player = new MainPlayer(world, 200, 500);

    }
    @Override
    public void show() {

    }

//    void handleInput(float dt) {
//        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
////            player.getBody().applyLinearImpulse(new Vector2(-10000, 0), player.getBody().getWorldCenter(), true);
//            System.out.println("Right ");
//            player.move(100, 0);
//        }else if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
////            player.getBody().applyLinearImpulse(new Vector2(10000, 0), player.getBody().getWorldCenter(), true);
//            System.out.println("Left");
//            player.move(-100, 0);
//        }else if(Gdx.input.isKeyPressed(Input.Keys.SPACE)){
////            player.getBody().applyForceToCenter(0, 800f, true);
//            player.getBody().setLinearVelocity(0, 8f);
//        }
//    }

    @Override
    public void render(float delta) {
//        handleInput(delta);
        player.update();

        ScreenUtils.clear(0, 0, 1, 1);

        game.getBatch().begin();

        worldTerrainController.drawTerrain();
        game.getBatch().draw(player, player.getX(), player.getY());

        game.getBatch().end();

        debugRenderer.render(world, renderCamera.combined);
        game.getBatch().setProjectionMatrix(mainCamera.combined);
        mainCamera.update();
        renderCamera.update();



        world.step(Gdx.graphics.getDeltaTime(), 6, 2);
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

    }
}
