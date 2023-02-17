package objects.gameplay.terrain.UI;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

import helpers.GameInfo;
import objects.gameplay.AtomicObject;

public class MazeRoom extends BasicRoom {
    public MazeRoom(SpriteBatch batch, World world, float startX, float startY, Array<BlockDirections> allowedDirections) {
        super(batch, world, startX, startY);

        Array<AtomicObject> blocks = getBlocks();
        destroyObjects(GameInfo.CENTER_ATOMIC_OBJECTS_INDICES, blocks);

        for(BlockDirections direction : allowedDirections) {
            switch (direction) {
                case UP:
                    destroyObjects(GameInfo.UP_ATOMIC_OBJECTS_INDICES, blocks);
                    break;
                case DOWN:
                    destroyObjects(GameInfo.DOWN_ATOMIC_OBJECTS_INDICES, blocks);
                    break;
                case LEFT:
                    destroyObjects(GameInfo.LEFT_ATOMIC_OBJECTS_INDICES, blocks);
                    break;
                case RIGHT:
                    destroyObjects(GameInfo.RIGHT_ATOMIC_OBJECTS_INDICES, blocks);
                    break;
            }
        }
    }

    void destroyObject(AtomicObject objectToBeDestroyed) {
        objectToBeDestroyed.dispose();
        world.destroyBody(objectToBeDestroyed.getBody());
    }

    void destroyObjects(int [] indexes, Array<AtomicObject> bs) {
        for (int index : indexes) {
            destroyObject(bs.get(index));
        }
    }
}
