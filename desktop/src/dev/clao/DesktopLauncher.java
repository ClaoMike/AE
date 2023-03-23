package dev.clao;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument

/**
 * The Desktop Launcher
 * For adding a run configuration:
 * - add a new Application configuration;
 * - name it Desktop;
 * - add the -XstartOnFirstThread JVM argument;
 * - select the desktop.main module.
 */
public class DesktopLauncher {
	public static void main (String[] arg) {
		int FPS = 60;
		String GAME_TITLE = "Spatium Explorationis";
		int DEFAULT_WINDOW_WIDTH = 1440;
		int DEFAULT_WINDOW_HEIGHT = 900;

		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(FPS);
		config.setTitle(GAME_TITLE);
		config.setWindowedMode(DEFAULT_WINDOW_WIDTH, DEFAULT_WINDOW_HEIGHT);
		new Lwjgl3Application(new GameMain(), config);
	}
}
