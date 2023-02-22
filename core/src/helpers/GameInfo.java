package helpers;

import com.badlogic.gdx.math.Vector2;

/**
 * Class to contain all the constant information for the game.
 * Categories are ordered in the following way:
 * MAIN, DESKTOP LAUNCHER, ASSETS and then the rest of classes in alphabetical order.
 */
public class GameInfo {
    ////////////////////////////////////////////////////////////////////////////////////////////////
    // MAIN
    public static final boolean DEBUG_MODE = false;
    public static final int PPM = 100;

    // DESKTOP LAUNCHER
    public static final int WIDTH = 1440;
    public static final int HEIGHT = 900;
    public static final int FPS = 60;
    public static final String TITLE = "Antrum Exploratio";

    // ASSETS
    public static final String PLAYER = "player.png";
    public static final String DIRT = "dirt.png";

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // ATOMIC OBJECT
    public static final float CIRCLE_SHAPE_RADIUS = 0.5f;

    // BASIC ROOM
    public static final int NUMBER_OF_BLOCKS_IN_BASIC_ROOM = 4;

    // BASIC SCREEN
    public static final Vector2 GRAVITY = new Vector2(0, 0); // world
    public static final boolean WORLD_DO_SLEEP = true;
    public static final int VELOCITY_ITERATIONS = 6;
    public static final int POSITION_ITERATIONS = 2;

    // MAIN MENU
    public static final float NUMBER_OF_SCREEN_DIVISIONS = 10f;
    public static final String PLAY_BUTTON_FILENAME = "buttons/play.png";
    public static final float PLAY_BUTTON_POSITION = 7f;
    public static final String SETTINGS_BUTTON_FILENAME = "buttons/settings.png";
    public static final float SETTINGS_BUTTON_POSITION = 5f;
    public static final String CREDITS_BUTTON_FILENAME = "buttons/credits.png";
    public static final float CREDITS_BUTTON_POSITION = 3f;
    public static final String EXIT_BUTTON_FILENAME = "buttons/exit.png";
    public static final float EXIT_BUTTON_POSITION = 1f;

    // MAIN PLAYER
    public static final float PLAYER_MAXIMUM_SPEED = 5f;
    public static final float PLAYER_FORCE = 8f;
    public static final float NULL_FORCE = 0f;

    // MAZE
    public static final int NUMBER_OF_CELLS_PER_EACH_ROW_IN_A_MAZE = 10;

    // MAZE ROOM
    public static final int[] CENTER_ATOMIC_OBJECTS_INDICES = {5, 6, 9, 10};
    public static final int[] LEFT_ATOMIC_OBJECTS_INDICES = {4, 8};
    public static final int[] RIGHT_ATOMIC_OBJECTS_INDICES = {7, 11};
    public static final int[] UP_ATOMIC_OBJECTS_INDICES = {13, 14};
    public static final int[] DOWN_ATOMIC_OBJECTS_INDICES = {1, 2};

    // PLATFORM
    public static final int NUMBER_OF_BASIC_ROOMS_IN_PLATFORM = 3;

    // WORLD TERRAIN GENERATOR
    public static final float WORLD_X = 200;
    public static final float WORLD_Y = 700;

    public static final float PLAYER_X = GameInfo.WIDTH/2f;
    public static final float PLAYER_Y = GameInfo.HEIGHT/2f;

    ////////////////////////////////////////////////////////////////////////////////////////////////
}
