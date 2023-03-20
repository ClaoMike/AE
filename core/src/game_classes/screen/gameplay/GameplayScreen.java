package game_classes.screen.gameplay;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;

import dev.clao.GameMain;
import game_classes.camera.FollowingCamera;
import game_classes.object.Satellite;
import game_classes.object.terrain.Terrain;
import game_classes.object.player.Player;
import game_classes.object.spaceship.Spaceship;
import game_classes.screen.blueprint.SimpleScreen;

public class GameplayScreen extends SimpleScreen {
    private final World world;
    private final FollowingCamera camera;
    private final Terrain terrain;
    private final Spaceship spaceship;
    private final Player player;
    private final Satellite satellite;
    private final Stage stage;
    private boolean isPaused = false;
    boolean escapeKeyPressed = false;
    boolean endOfTheGame = false;

    public GameplayScreen(GameMain game) {
        super(game);

        Vector2 originCoordinates = new Vector2(0, 0);
        Vector2 worldForces = originCoordinates.cpy();

        world = new World(worldForces, true);
        GameUtils utils = new GameUtils(game, world);

        //camera
        camera = new FollowingCamera(utils);
        //terrain
        terrain = new Terrain(utils, new Vector2(0, 0));
        // spaceship
        spaceship = new Spaceship(utils, -300, 0);
        //player
        player = new Player(utils);
        new EndDetection(utils, player, this);
        satellite = new Satellite(terrain.getEndPlatformMiddleCoordinates(), utils);

        stage = new Stage();
        PauseMenu pauseMenu = new PauseMenu(game, font, this);
        stage.addActor(pauseMenu);

        //TODO:
        // 2. Add sound effects here in gameplay and when pressing a button;
        // 3. Add animations;
        // 4. Update game version;
        // 5. (OPTIONAL) Add a snow animation;
        // 6. Remove all warnings;
        // 7. One last refactor;
        // 8. Finally, finish the README file;
        // 9. Submit the project.
    }

    @Override
    public void show() {
    }

    public void showEndMenu() {
        stage.clear();

        EndMenu endMenu = new EndMenu(game, font);
        stage.addActor(endMenu);
        endOfTheGame = true;
        isPaused = true;
        Gdx.input.setInputProcessor(stage);
    }

    public void dismissPauseMenu() {
        escapeKeyPressed = true;
        isPaused = !isPaused;
        player.setInputProcessorToPlayer();
    }

    private void updatePositions() {
        // terrain
        terrain.updatePosition();
        // spaceship
        spaceship.updatePosition();
        // player
        player.updatePosition();
        satellite.updatePosition();
    }

    private void draw() {
        // terrain
        terrain.draw();
        // spaceship
        spaceship.draw();
        // satellite
        satellite.draw();
        satellite.draw();

        if(isPaused) {
            stage.draw();
        } else {
            // player
            player.draw();
        }

    }

    @Override
    public void render(float delta) {
        // Clear screen
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Update the world by making a step
        world.step(Gdx.graphics.getDeltaTime(),getConstants().VELOCITY_ITERATIONS, getConstants().POSITION_ITERATIONS);
        camera.setProjection();

        // Detect user input
        detectUserInput();

        // Update position of sprites based on their bodies
        updatePositions();

        // Draw the sprites
        getBatch().begin();
        draw();
        getBatch().end();

        // Update cameras
        camera.followSpriteAndBodyOf(player.getSprite());
    }

    private void detectUserInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE) && !endOfTheGame) {
            if (!escapeKeyPressed) {
                escapeKeyPressed = true;
                isPaused = !isPaused;

                if(isPaused) {
                Gdx.input.setInputProcessor(stage);
                } else {
                    player.setInputProcessorToPlayer();
                }
            }
        } else {
            escapeKeyPressed = false;
        }
    }

    @Override
    public void resize(int width, int height) {
        camera.resize(width, height);
    }

    @Override
    public void dispose() {
        terrain.dispose();
        spaceship.dispose();
        player.dispose();
        satellite.dispose();
        satellite.dispose();
        stage.dispose();
    }
}