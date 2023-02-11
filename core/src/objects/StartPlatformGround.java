package objects;

import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

import dev.clao.GameMain;

public class StartPlatformGround {
    private final int numberOfDirtBlocks = 6;
    private final float startPositionX = 0;
    private final float startPositionY = 0;

    private Array<DirtBlock> startPlatform = new Array<>();
    private World world;

    public StartPlatformGround(World world) {
        this.world = world;

        float x = startPositionX;
        for (int i=0; i<numberOfDirtBlocks; i++) {
            DirtBlock db = new DirtBlock(world, x, startPositionY);
            x += db.getSize();
            startPlatform.add(db);
        }
    }

    public void draw(GameMain game) {
        for(DirtBlock db: startPlatform) {
            db.draw(game);
        }
    }
}
