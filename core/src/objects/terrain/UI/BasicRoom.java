package objects.terrain.UI;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

import helpers.GameInfo;
import objects.AtomicObject;
import objects.Drawable;

public class BasicRoom implements Drawable {
    private final Array<AtomicObject> blocks = new Array<>();
    protected final World world;
    private final SpriteBatch batch;
    private final float blockSize;

    public BasicRoom(SpriteBatch batch, World world, float startX, float startY) {
        this.batch = batch;
        this.world = world;

        float x = startX;
        float blockHeight = 0;

        int numberOfBlocksPerRow = GameInfo.NUMBER_OF_BLOCKS_IN_BASIC_ROOM;
        for(int j = 0; j < numberOfBlocksPerRow; j++) {
            for(int i = 0; i< numberOfBlocksPerRow; i++) {
                AtomicObject ao = new AtomicObject(
                        GameInfo.DIRT,
                        x,
                        startY,
                        world,
                        BodyDef.BodyType.StaticBody,
                        1,
                        false,
                        false);
                blocks.add(ao);
                x += ao.getWidth();
                blockHeight = ao.getHeight();
            }
            startY += blockHeight;
            x = startX;
        }

        blockSize = blockHeight * numberOfBlocksPerRow;
    }

    public void draw() {
        for (AtomicObject ao : blocks) {
            ao.draw(batch);
        }
    }

    public void updatePosition() {
        for (AtomicObject ao : blocks) {
            ao.updatePosition();
        }
    }

    public void dispose() {
        for (AtomicObject ao : blocks) {
            ao.dispose();
        }
    }

    public float getSize() {
        return blockSize;
    }

    protected Array<AtomicObject> getBlocks() {
        return blocks;
    }
}

