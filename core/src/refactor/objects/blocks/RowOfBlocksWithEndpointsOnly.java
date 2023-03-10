package refactor.objects.blocks;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

import dev.clao.GameMain;

public class RowOfBlocksWithEndpointsOnly {
    private final Array<Block> blocks = new Array<>();


    public RowOfBlocksWithEndpointsOnly(GameMain game, World world, Vector2 coordinates) {
        String blockFilepath = game.getConstants().BLOCK_IMAGE_FILEPATH;
        Vector2 blockSize = Block.getSize(blockFilepath);

        Block b1 = new Block(game, blockFilepath, world, coordinates, false);
        blocks.add(b1);
        coordinates.x = coordinates.x + 3 * blockSize.x;

        Block b2 = new Block(game, blockFilepath, world, coordinates, false);
        blocks.add(b2);
    }

    public void draw() {
        for(Block b: blocks) {
            b.draw();
        }
    }

    public void updatePosition() {
        for(Block b: blocks) {
            b.updatePosition();
        }
    }

    public void dispose() {
        for(Block b: blocks) {
            b.dispose();
        }
    }
}
