package dev.clao;

import static refactor.screens.Screens.MAIN_MENU;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Json;

import refactor.Constants;
import refactor.screens.CreditsScreen;
import refactor.screens.MainMenuScreen;
import refactor.screens.Screens;
import refactor.screens.SettingsScreen;

/**
 * Busy with creating a sprite batch for drawing textures;
 * WARNING: Create one and only one SpriteBatch for the entire game!
 */
public class GameMain extends Game {
	private Constants constants;
	private SpriteBatch batch;

	public SpriteBatch getBatch() {
		return batch;
	}

	@Override
	public void create () {
		loadConstants();
		batch = new SpriteBatch();
		goToScreen(MAIN_MENU);
	}

	@Override
	public void dispose() {
		super.dispose();
		batch.dispose();
	}

	@Override
	public void render () {
		super.render();
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
