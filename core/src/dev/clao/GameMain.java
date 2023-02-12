package dev.clao;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import helpers.GameInfo;
import screens.BasicScreen;

public class GameMain extends Game {
	private SpriteBatch batch;
	private boolean debugMode = GameInfo.DEBUG_MODE;

	public SpriteBatch getBatch() {
		return batch;
	}

	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new BasicScreen(this, debugMode));
	}

	@Override
	public void render () {
		super.render();
	}

}
