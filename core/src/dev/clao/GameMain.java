package dev.clao;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import helpers.GameInfo;
import screens.BasicScreen;

public class GameMain extends Game {
	private SpriteBatch batch;

	public SpriteBatch getBatch() {
		return batch;
	}

	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new BasicScreen(this, GameInfo.DEBUG_MODE));
	}

	@Override
	public void render () {
		super.render();
	}

}
