package dev.clao;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import scenes.Gameplay;

public class GameMain extends Game {
	private SpriteBatch batch;

	public SpriteBatch getBatch() {
		return batch;
	}

	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new Gameplay(this));
//		setScreen(new BasicScene(this));
	}

	@Override
	public void render () {
		super.render();
	}

}
