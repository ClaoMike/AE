package objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

public class MazeRoom extends BasicRoom {
    int[] centerObjectsIndexes = {6, 7, 10, 11};
    int[] leftObjectsIndexes = {5, 9};
    int[] rightObjectsIndexes = {8, 12};
    int[] upObjectsIndexes = {2, 3};
    int[] downObjectsIndexes = {14, 15};
    public MazeRoom(SpriteBatch batch, World world, float startX, float startY) {
        super(batch, world, startX, startY);

        AtomicObject objectToBeDestroyed;
        Array<AtomicObject> blocks = getBlocks();

        for (int i = 0; i < centerObjectsIndexes.length; i++) {
            destroyObject(blocks.get(centerObjectsIndexes[i]));
        }
    }

    void destroyObject(AtomicObject objectToBeDestroyed) {
        objectToBeDestroyed.dispose();
        world.destroyBody(objectToBeDestroyed.getBody());
    }
}
