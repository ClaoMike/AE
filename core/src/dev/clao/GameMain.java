package dev.clao;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import screens.Gameplay;
import screens.GameplayScreen;
import screens.SimpleScreen;

public class GameMain extends Game {
	private SpriteBatch batch;

	public SpriteBatch getBatch() {
		return batch;
	}

	@Override
	public void create () {
		batch = new SpriteBatch();
//		setScreen(new Gameplay(this));
//		setScreen(new SimpleScreen(this));
		setScreen(new GameplayScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}

}
