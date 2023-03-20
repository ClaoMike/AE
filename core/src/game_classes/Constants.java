package game_classes;

import com.badlogic.gdx.graphics.Color;

public class Constants {
    public static final Color SLIDER_DEFAULT_COLOUR = Color.YELLOW;
    public static final Color SLIDER_CHECK_COLOUR = Color.RED;
    public static final float PPM = 100;
    public static final int BLOCK_SIZE = 100;
    public static final String SNOW_IMAGE_FILEPATH = "images/gameplay/terrain/snow.png";
    public static final String DIRT_IMAGE_FILEPATH = "images/gameplay/terrain/dirt.png";
    public static final String DIRT_WITH_SNOW_UP_IMAGE_FILEPATH = "images/gameplay/terrain/dirt_with_snow/up.png";
    public static final String DIRT_WITH_SNOW_DOWN_IMAGE_FILEPATH = "images/gameplay/terrain/dirt_with_snow/down.png";
    public static final String DIRT_WITH_SNOW_LEFT_IMAGE_FILEPATH = "images/gameplay/terrain/dirt_with_snow/left.png";
    public static final String DIRT_WITH_SNOW_RIGHT_IMAGE_FILEPATH = "images/gameplay/terrain/dirt_with_snow/right.png";

    public static final String DIRT_WITH_SNOW_CORNER_TOP_LEFT_IMAGE_FILEPATH = "images/gameplay/terrain/dirt_with_snow_corner/top_left.png";
    public static final String DIRT_WITH_SNOW_CORNER_TOP_RIGHT_IMAGE_FILEPATH = "images/gameplay/terrain/dirt_with_snow_corner/top_right.png";
    public static final String DIRT_WITH_SNOW_CORNER_BOTTOM_LEFT_IMAGE_FILEPATH = "images/gameplay/terrain/dirt_with_snow_corner/bottom_left.png";
    public static final String DIRT_WITH_SNOW_CORNER_BOTTOM_RIGHT_IMAGE_FILEPATH = "images/gameplay/terrain/dirt_with_snow_corner/bottom_right.png";

    public String BACKGROUND_IMAGE_FILEPATH;
    public String BACKGROUND_MUSIC_FILEPATH;
    public String DEBUG_MODE_CHECKBOX_TITLE;
    public boolean DEBUG_MODE_DEFAULT_VALUE;
    public static final String EMPTY_STRING = "";
    public int FONT_DEFAULT_SIZE;
    public String FONT_FILEPATH;
    public String GAME_TITLE;
    public int GAME_TITLE_BOTTOM_PADDING;
    public String GAME_VERSION;
    public static final String JSON_CONSTANTS_FILEPATH = "json/constants.json";
    public int MAIN_MENU_BUTTON_BOTTOM_PADDING;
    public String MAIN_MENU_BUTTON_CREDITS;
    public String MAIN_MENU_BUTTON_EXIT;
    public String MAIN_MENU_BUTTON_PLAY;
    public String MAIN_MENU_BUTTON_SETTINGS;
    public String PLAYER_IMAGE_FILEPATH;
    public float PLAYER_INITIAL_POSITION;
    public float PLAYER_MAXIMUM_LINEAR_VELOCITY;
    public float PLAYER_MOVEMENT_FORCE;
    public static final String PNG_EXTENSION = ".png";
    public int POSITION_ITERATIONS;
    public String PROJECT_DEVELOPER;
    public String PROJECT_SUPERVISOR;
    public int SETTINGS_SLIDER_DEFAULT_VALUE;
    public int SETTINGS_SLIDER_MAX_VALUE;
    public int SETTINGS_SLIDER_MIN_VALUE;
    public int SETTINGS_SLIDER_STEP_VALUE;
    public String SLIDER_BACKGROUND;
    public String SLIDER_KNOB_BACKGROUND;
    public String SLIDER_MAZE_SIZE_TITLE;
    public String SPACESHIP_IMAGE_FILEPATH;
    public String UNIVERSITY_NAME;
    public int VELOCITY_ITERATIONS;
    public String END_SENSOR_NAME;
    public static final String SATELLITE_IMAGE_FILEPATH = "images/gameplay/satellite/satellite.png";
    public static final String NEW_SATELLITE_IMAGE_FILEPATH = "satellite_animation.png";
    public static final String GAME_MENU_BACKGROUND_IMAGE_FILEPATH = "images/gameplay/ui/game_menu_background.png";
    public static final String MAIN_MENU_STRING = "Main Menu";
    public static final String PLAY_AGAIN_STRING = "Play again";
    public static final String RESUME_STRING = "Resume";

    public static String removePNGExtension(String filename) {
        return filename.replaceAll(PNG_EXTENSION, EMPTY_STRING);
    }
}
