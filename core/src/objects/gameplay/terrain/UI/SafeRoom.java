package objects.gameplay.terrain.UI;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

import objects.gameplay.Drawable;

public class SafeRoom implements Drawable {
    private int number_of_platforms = 1;
    private final Array<Platform> bottomPlatform = new Array<>();
    private BasicRoom b;
    private final Array<Platform> topPlatform = new Array<>();

    public SafeRoom(SpriteBatch batch, World world, float x, float y) {
        for (int i = 0; i < number_of_platforms; i++) {
            Platform p = new Platform(batch, world, x, y);
            bottomPlatform.add(p);
        }

        b = new BasicRoom(batch, world, x, y);
        y -= b.getSize();
        b.dispose();
        b = new BasicRoom(batch, world, x, y);

        y -= b.getSize();

        for (int i = 0; i < number_of_platforms; i++) {
            Platform p = new Platform(batch, world, x, y);
            topPlatform.add(p);
        }
    }

    @Override
    public void draw() {
        b.draw();
        for(Platform p : bottomPlatform) {
            p.draw();
        }
        for(Platform p : topPlatform) {
            p.draw();
        }
    }

    @Override
    public void updatePosition() {
        b.updatePosition();
        for(Platform p : bottomPlatform) {
            p.updatePosition();
        }

        for(Platform p : topPlatform) {
            p.updatePosition();
        }
    }

    @Override
    public void dispose() {
        b.dispose();
        for(Platform p : bottomPlatform) {
            p.dispose();
        }
        for(Platform p : topPlatform) {
            p.dispose();
        }
    }
}
