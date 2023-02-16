package dev.clao;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import screens.BasicScreen;
import screens.MainMenuScreen;

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
//		setScreen(new BasicScreen(this));
		setScreen(new MainMenuScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}

}
