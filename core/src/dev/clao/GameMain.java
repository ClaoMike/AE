package dev.clao;

import static game_classes.screen.Screens.GAMEPLAY;
import static game_classes.screen.Screens.MAIN_MENU;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Json;

import game_classes.music.CustomMusic;
import game_classes.Constants;
import game_classes.screen.settings.GameSettings;
import game_classes.screen.credits.CreditsScreen;
import game_classes.screen.main_menu.MainMenuScreen;
import game_classes.screen.gameplay.GameplayScreen;
import game_classes.screen.Screens;
import game_classes.screen.settings.SettingsScreen;

/**
 * Busy with creating a sprite batch for drawing textures;
 * WARNING: Create one and only one SpriteBatch for the entire game!
 */
public class GameMain extends Game {
	private Constants constants;
	private SpriteBatch batch;
	private CustomMusic customMusic;

	public SpriteBatch getBatch() {
		return batch;
	}
	public GameSettings settings;

	public void playMusic() {
		if(!customMusic.isPlaying())
			customMusic.play();
	}

	@Override
	public void create () {
		loadConstants();
		batch = new SpriteBatch();

		customMusic = new CustomMusic(getConstants().BACKGROUND_MUSIC_FILEPATH);
		customMusic.play();

		settings = new GameSettings(getConstants());

		if(constants.DEBUG_MODE_DEFAULT_VALUE) {
			goToScreen(GAMEPLAY);
		} else {
			goToScreen(MAIN_MENU);
		}

	}

	@Override
	public void dispose() {
		super.dispose();
		batch.dispose();
		customMusic.dispose();
	}

	private void loadConstants() {
		Json json = new Json();
		constants = json.fromJson(Constants.class, Gdx.files.internal(Constants.JSON_CONSTANTS_FILEPATH));
	}

	public Constants getConstants() {
		return constants;
	}

	public void exit() {
		System.exit(0);
	}

	public void goToScreen(Screens s) {
		switch (s) {
			case GAMEPLAY:
				customMusic.stop();
				setScreen(new GameplayScreen(this));

				break;
			case MAIN_MENU:
				setScreen(new MainMenuScreen(this));
				break;
			case CREDITS:
				setScreen(new CreditsScreen(this));
				break;
			case SETTINGS:
				setScreen(new SettingsScreen(this));
				break;
		}
	}
}
