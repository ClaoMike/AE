package screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

import objects.AtomicObject;

public class Examplee implements Screen {
    private World world;
    private SpriteBatch spriteBatch;
    private AtomicObject a1, a2;
    private FollowingCamera camera;

    @Override
    public void show() {
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();

        world = new World(new Vector2(0, -10), true);

        spriteBatch = new SpriteBatch();
        a1 = new AtomicObject("player.png", w/2, h/2, world, BodyDef.BodyType.DynamicBody);
        a2 = new AtomicObject("player.png", w/3, h/3, world, BodyDef.BodyType.StaticBody);

        camera = new FollowingCamera(spriteBatch, world,w, h, false, a1);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        world.step(Gdx.graphics.getDeltaTime(), 6, 2);

        a1.updatePosition();
        a2.updatePosition();

        camera.update();

        spriteBatch.begin();
        a1.draw(spriteBatch);
        a2.draw(spriteBatch);
        spriteBatch.end();

        camera.render();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        world.dispose();
        camera.dispose();
        spriteBatch.dispose();
        a1.dispose();
        a2.dispose();
    }

}
