package refactor.objects.blocks.structures;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

import dev.clao.GameMain;
import refactor.objects.blocks.Block;
import refactor.objects.blueprints.CustomSprite;
import refactor.screens.gameplay.GameUtils;

public class StructureOfBlocks {
    protected final Array<Block> blocks = new Array<>();
    protected Array<CustomSprite> sprites = new Array<>();
    protected final GameMain game;
    protected final World world;
    protected Vector2 coordinates;
    protected String blockFilepath;
    protected Vector2 blockSize;

    public StructureOfBlocks(GameMain game, World world, Vector2 coordinates) {
        this.game = game;
        this.world = world;
        this.coordinates = coordinates.cpy();

        blockFilepath = game.getConstants().SNOW_IMAGE_FILEPATH;
        blockSize = Block.getSize(blockFilepath);
    }

    public StructureOfBlocks(GameUtils utils, Vector2 coordinates) {
        this.game = utils.game;
        this.world = utils.world;
        this.coordinates = coordinates.cpy();

        blockFilepath = game.getConstants().SNOW_IMAGE_FILEPATH;
        blockSize = Block.getSize(blockFilepath);
    }

    public void draw() {
        for(Block b: blocks) {
            b.draw();
        }

        for(CustomSprite s: sprites) {
            game.getBatch().draw(s, s.getX(), s.getY());
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
