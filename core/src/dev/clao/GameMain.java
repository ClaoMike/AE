package dev.clao;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import screens.CreditsScreen;
import screens.GameplayScreen;
import screens.MainMenuScreen;
import screens.SettingsScreen;

/**
 * Busy with creating a sprite batch for drawing textures;
 * WARNING: Create one and only one SpriteBatch for the entire game!
 */
public class GameMain extends Game {
	private SpriteBatch batch;

	public SpriteBatch getBatch() {
		return batch;
	}

	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new MainMenuScreen(this));
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
