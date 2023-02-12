//package screens;
//
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.Screen;
//import com.badlogic.gdx.graphics.GL20;
//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.badlogic.gdx.math.Vector2;
//import com.badlogic.gdx.math.Vector3;
//import com.badlogic.gdx.physics.box2d.Box2D;
//import com.badlogic.gdx.physics.box2d.World;
//
//import dev.clao.GameMain;
//import helpers.GameInfo;
//
//public class SimpleScreen implements Screen, ScreenUtils {
//    private GameMain game;
//    private ScreenCamera camera;
//    protected World world;
//    private float accumulator = 0;
//
//    public SimpleScreen(GameMain game) {
//        Box2D.init();
//
//        this.game = game;
//        world = new World(new Vector2(0, -GameInfo.GRAVITY), true);
//        camera = new ScreenCamera(game, world);
//
//        createObjects();
//    }
//
//    @Override
//    public void show() {
//
//    }
//
//    @Override
//    public void render(float delta) {
//        stepWorld();
//
//        Gdx.gl.glClearColor( 1, 0, 0, 1 );
//        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );
//
//        game.getBatch().begin();
//        drawObjects();
//        game.getBatch().end();
//
//        updateObjects();
//        camera.update();
//    }
//
//    @Override
//    public void resize(int width, int height) {
//        camera.resize(width, height);
//    }
//
//    @Override
//    public void pause() {
//
//    }
//
//    @Override
//    public void resume() {
//
//    }
//
//    @Override
//    public void hide() {
//
//    }
//
//    @Override
//    public void dispose() {
//        world.dispose();
//        camera.dispose();
//    }
//
//    private void stepWorld() {
//        float delta = Gdx.graphics.getDeltaTime();
//
//        accumulator += Math.min(delta, 0.25f);
//
//        if (accumulator >= GameInfo.STEP_TIME) {
//            accumulator -= GameInfo.STEP_TIME;
//
//            world.step(GameInfo.STEP_TIME, GameInfo.VELOCITY_ITERATIONS, GameInfo.POSITION_ITERATIONS);
//        }
//    }
//
//    @Override
//    public void createObjects() {
//
//    }
//
//    @Override
//    public void drawObjects() {
//
//    }
//
//    @Override
//    public void updateObjects() {
//    }
//
//    public void updateCameraPosition(Vector3 position) {
//        camera.updatePosition(position);
//    }
//
//    public SpriteBatch getBatch() {
//        return game.getBatch();
//    }
//
//}
