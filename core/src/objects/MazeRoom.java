package objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

// 13 14 15 16
//  9 10 11 12
//  5  6  7  8
//  1  2  3  4

//  1  2  3  4
//  5  6  7  8
//  9 10 11 12
// 13 14 15 16

//  0 1  2  3
//  4 5  6  7
//  8 9 10 11
// 12 14 15 16

public class MazeRoom extends BasicRoom {
    int[] centerObjectsIndexes = {5, 6, 9, 10};
    int[] leftObjectsIndexes = {4, 8};
    int[] rightObjectsIndexes = {7, 11};
    int[] upObjectsIndexes = {13, 14};
    int[] downObjectsIndexes = {1, 2};

    public MazeRoom(SpriteBatch batch, World world, float startX, float startY, Array<BlockDirections> allowedDirections) {
        super(batch, world, startX, startY);

        AtomicObject objectToBeDestroyed;
        Array<AtomicObject> blocks = getBlocks();

        destroyObjects(centerObjectsIndexes, blocks);

        for(BlockDirections direction : allowedDirections) {
            switch (direction) {
                case UP:
                    destroyObjects(upObjectsIndexes, blocks);
                    break;
                case DOWN:
                    destroyObjects(downObjectsIndexes, blocks);
                    break;
                case LEFT:
                    destroyObjects(leftObjectsIndexes, blocks);
                    break;
                case RIGHT:
                    destroyObjects(rightObjectsIndexes, blocks);
                    break;
            }
        }
    }

    void destroyObject(AtomicObject objectToBeDestroyed) {
        objectToBeDestroyed.dispose();
        world.destroyBody(objectToBeDestroyed.getBody());
    }

    void destroyObjects(int [] indexes, Array<AtomicObject> bs) {
        for (int i = 0; i < indexes.length; i++) {
            destroyObject(bs.get(indexes[i]));
        }
    }
}
