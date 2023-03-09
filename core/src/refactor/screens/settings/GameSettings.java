package refactor.screens.settings;

import refactor.Constants;

public class GameSettings {
    private boolean DEBUG_MODE;
    private int MAZE_SIZE;

    public GameSettings(Constants c) {
        DEBUG_MODE = c.DEBUG_MODE_DEFAULT_VALUE;
        MAZE_SIZE = c.SETTINGS_SLIDER_DEFAULT_VALUE;
    }

    public void setDebugMode(boolean value) {
        DEBUG_MODE = value;
    }

    public boolean getDebugMode() {
        return DEBUG_MODE;
    }

    public void setMazeSize(int value) {
        MAZE_SIZE = value;
    }

    public int getMazeSize() {
        return MAZE_SIZE;
    }

}
