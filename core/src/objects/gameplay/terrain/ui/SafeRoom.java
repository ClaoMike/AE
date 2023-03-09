package objects.gameplay.terrain.ui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;

import objects.gameplay.Drawable;

public class SafeRoom implements Drawable {
    private final Platform bottomPlatform;
    private BasicRoom wall;
    private final Platform topPlatform;

    public SafeRoom(SpriteBatch batch, World world, float x, float y, boolean placeWallToTheLeft) {
        wall = new BasicRoom(batch, world, x, y);
        float wallSize = wall.getSize();
        wall.dispose();

        bottomPlatform = new Platform(batch, world, x, y);

        y -= wallSize*2;

        topPlatform = new Platform(batch, world, x, y);

        if(!placeWallToTheLeft) {
            x += topPlatform.getWidth() - wallSize;
        }
        y += wallSize;

        wall = new BasicRoom(batch, world, x, y);
    }

    @Override
    public void draw() {
        wall.draw();
        bottomPlatform.draw();
        topPlatform.draw();
    }

    @Override
    public void updatePosition() {
        wall.updatePosition();
        bottomPlatform.updatePosition();
        topPlatform.updatePosition();
    }

    @Override
    public void dispose() {
        wall.dispose();
        bottomPlatform.dispose();
        topPlatform.dispose();
    }

    public float getSize() {
        return bottomPlatform.getWidth();
    }

}
