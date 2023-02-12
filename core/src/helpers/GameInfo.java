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
    // BASIC SCREEN
    public static final Vector2 GRAVITY = new Vector2(0, -9.81f); // world
    public static final boolean WORLD_DO_SLEEP = true;
    public static final int VELOCITY_ITERATIONS = 6;
    public static final int POSITION_ITERATIONS = 2;

    ////////////////////////////////////////////////////////////////////////////////////////////////
}
