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
    public static final boolean DEBUG_MODE = true;
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
    public static final Vector2 GRAVITY = new Vector2(0, -9.81f); // world
    public static final boolean WORLD_DO_SLEEP = true;
    public static final int VELOCITY_ITERATIONS = 6;
    public static final int POSITION_ITERATIONS = 2;

    // MAIN PLAYER
    public static final float PLAYER_HORIZONTAL_MAX_SPEED = 5f;
    public static final float PLAYER_HORIZONTAL_IMPULSE = 0.8f;

    public static final float PLAYER_UPWARDS_MAX_SPEED = 3f;
    public static final float PLAYER_UPWARDS_IMPULSE = 0.8f;
    public static final float PLAYER_DOWNWARDS_IMPULSE = 0.9f;

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
    public static final float START_POSITION_X = 0;
    public static final float START_POSITION_Y = 0;

    ////////////////////////////////////////////////////////////////////////////////////////////////
}
