package dev.clao;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import helpers.GameInfo;

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
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(GameInfo.FPS);
		config.setTitle(GameInfo.TITLE);
		config.setWindowedMode(GameInfo.WIDTH, GameInfo.HEIGHT);
		new Lwjgl3Application(new GameMain(), config);
	}
}
