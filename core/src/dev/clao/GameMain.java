package dev.clao;

import static refactor.screens.Screens.GAMEPLAY;
import static refactor.screens.Screens.MAIN_MENU;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Json;

import refactor.Constants;
import refactor.GameSettings;
import refactor.screens.CreditsScreen;
import refactor.screens.MainMenuScreen;
import refactor.screens.NewGameplayScreen;
import refactor.screens.Screens;
import refactor.screens.SettingsScreen;

/**
 * Busy with creating a sprite batch for drawing textures;
 * WARNING: Create one and only one SpriteBatch for the entire game!
 */
public class GameMain extends Game {
	private Constants constants;
	private SpriteBatch batch;
	private BackgroundMusic backgroundMusic;

	public SpriteBatch getBatch() {
		return batch;
	}
	public GameSettings settings;

	@Override
	public void create () {
		loadConstants();
		batch = new SpriteBatch();

		backgroundMusic = new BackgroundMusic(getConstants().BACKGROUND_MUSIC_FILEPATH);
		settings = new GameSettings(getConstants());

//		goToScreen(MAIN_MENU);
		goToScreen(GAMEPLAY);
	}

	@Override
	public void dispose() {
		super.dispose();
		batch.dispose();
		backgroundMusic.dispose();
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
				backgroundMusic.stop();
//				setScreen(new GameplayScreen(this));
				setScreen(new NewGameplayScreen(this)); //TODO: Rename this to GameplayScreen after refactoring everything

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
