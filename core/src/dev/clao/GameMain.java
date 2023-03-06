package dev.clao;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Json;

import refactor.Constants;
import refactor.screen.blueprint.SimpleScreen;
import refactor.screen.blueprint.UIScreen;
import screens.CreditsScreen;
import screens.GameplayScreen;
import screens.SettingsScreen;

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
		setScreen(new UIScreen(this));
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

	public void gotToPlay() {
		setScreen(new GameplayScreen(this));
	}

	public void goToSettings() {
		setScreen(new SettingsScreen(this));
	}

	public void goToCredits() {
		setScreen(new CreditsScreen(this));
	}

	public void exit() {
		System.exit(0);
	}
}
