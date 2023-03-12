package refactor.objects.blocks.structures;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

import refactor.objects.Directions;
import refactor.objects.blocks.Block;
import refactor.objects.blocks.pairOfBlocks.HorizontalPairOfBlocks;
import refactor.objects.blocks.pairOfBlocks.VerticalPairOfBlocks;
import refactor.objects.blueprints.CustomSprite;
import refactor.screens.gameplay.GameUtils;

public class BigBlockWithWalls extends BigBlockWithCornersOnly {
    private Directions[] wallDirections;
    GameUtils utils;
    private Array<CustomSprite> sprites = new Array<>();

    public BigBlockWithWalls(GameUtils utils, Vector2 coordinates, Directions[] wallDirections) {
        super(utils, coordinates);

        this.utils = utils;
        this.wallDirections = wallDirections;

        addWalls();
        addDirt();

    }

    public float getWidth() {
        return blockSize.x*4;
    }

    private void addDirt() {
        CustomSprite sprite;
        sprite = new CustomSprite(game.getConstants().DIRT_IMAGE_FILEPATH);
        sprite.setPosition(400,350);
        sprites.add(sprite);
    }

    private void addWalls() {
        if( wallDirections != null) {
            for(Directions d: wallDirections) {
                switch (d) {
                    case RIGHT:
                        blocks.addAll(

                                );
                        break;
                    case LEFT:
                        blocks.addAll(
//                                new Block(game, game.getConstants().BLOCK_IMAGE_FILEPATH, world, new Vector2(coordinates.x, coordinates.y+ this.blockSize.y), false),
//                                new Block(game, game.getConstants().BLOCK_IMAGE_FILEPATH, world, new Vector2(coordinates.x, coordinates.y+ this.blockSize.y*2), false)
                        );
                        break;
                    case DOWN:
                        blocks.addAll(
//                                new Block(game, game.getConstants().BLOCK_IMAGE_FILEPATH, world, new Vector2(coordinates.x + this.blockSize.x, coordinates.y), false),
//                                new Block(game, game.getConstants().BLOCK_IMAGE_FILEPATH, world, new Vector2(coordinates.x+ this.blockSize.x*2, coordinates.y), false)
                        );
                        break;
                    case UP:
                        blocks.addAll(
//                                new Block(game, game.getConstants().BLOCK_IMAGE_FILEPATH, world, new Vector2(coordinates.x + this.blockSize.x, coordinates.y + this.blockSize.y * 3), false),
//                                new Block(game, game.getConstants().BLOCK_IMAGE_FILEPATH, world, new Vector2(coordinates.x + this.blockSize.x*2, coordinates.y + this.blockSize.y * 3), false)
                        );
                        break;
                }
            }
        }
    }

}
