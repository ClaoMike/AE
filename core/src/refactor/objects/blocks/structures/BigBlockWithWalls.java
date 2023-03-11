package refactor.objects.blocks.structures;

import com.badlogic.gdx.math.Vector2;

import refactor.objects.Directions;
import refactor.objects.blocks.Block;
import refactor.objects.blocks.pairOfBlocks.HorizontalPairOfBlocks;
import refactor.objects.blocks.pairOfBlocks.VerticalPairOfBlocks;
import refactor.screens.gameplay.GameUtils;

public class BigBlockWithWalls extends BigBlockWithCornersOnly {
    private Directions[] wallDirections;
    GameUtils utils;

    public BigBlockWithWalls(GameUtils utils, Vector2 coordinates, Directions[] wallDirections) {
        super(utils, coordinates);

        this.utils = utils;
        this.wallDirections = wallDirections;

        addWalls();
//        addDirt();
    }

    private void addWalls() {
        if( wallDirections != null) {
            for(Directions d: wallDirections) {
                switch (d) {
                    case RIGHT:
                        blocks.addAll(new VerticalPairOfBlocks(utils, new Vector2(coordinates.x + this.blockSize.x * 3, coordinates.y + this.blockSize.y )).blocks);
                        break;
                    case LEFT:
                        blocks.addAll(new VerticalPairOfBlocks(utils, new Vector2(coordinates.x, coordinates.y+ this.blockSize.y)).blocks);
                        break;
                    case DOWN:
                        blocks.addAll(new HorizontalPairOfBlocks(utils, new Vector2(coordinates.x + this.blockSize.x, coordinates.y)).blocks);
                        break;
                    case UP:
                        blocks.addAll(new HorizontalPairOfBlocks(utils, new Vector2(coordinates.x + this.blockSize.x, coordinates.y + this.blockSize.y * 3)).blocks);
                        break;
                }
            }
        }
    }

    private void addDirt() {
        if( wallDirections != null) {
            for(Directions d: wallDirections) {
                switch (d) {
                    case RIGHT:
                        blocks.addAll(
                                new Block(game, game.getConstants().BLOCK_IMAGE_FILEPATH, this.world, new Vector2(coordinates.x + this.blockSize.x * 3, coordinates.y + this.blockSize.y ), false),
                                new Block(game, game.getConstants().BLOCK_IMAGE_FILEPATH, world, new Vector2(coordinates.x  + this.blockSize.x * 3, coordinates.y+ this.blockSize.y *2), false)
                        );
                        break;
                    case LEFT:
                        blocks.addAll(
                                new Block(game, game.getConstants().BLOCK_IMAGE_FILEPATH, world, new Vector2(coordinates.x, coordinates.y+ this.blockSize.y), false),
                                new Block(game, game.getConstants().BLOCK_IMAGE_FILEPATH, world, new Vector2(coordinates.x, coordinates.y+ this.blockSize.y*2), false)
                        );
                        break;
                    case DOWN:
                        blocks.addAll(
                                new Block(game, game.getConstants().BLOCK_IMAGE_FILEPATH, world, new Vector2(coordinates.x + this.blockSize.x, coordinates.y), false),
                                new Block(game, game.getConstants().BLOCK_IMAGE_FILEPATH, world, new Vector2(coordinates.x+ this.blockSize.x*2, coordinates.y), false)
                        );
                        break;
                    case UP:
                        blocks.addAll(
                                new Block(game, game.getConstants().BLOCK_IMAGE_FILEPATH, world, new Vector2(coordinates.x + this.blockSize.x, coordinates.y + this.blockSize.y * 3), false),
                                new Block(game, game.getConstants().BLOCK_IMAGE_FILEPATH, world, new Vector2(coordinates.x + this.blockSize.x*2, coordinates.y + this.blockSize.y * 3), false)
                        );
                        break;
                }
            }
        }
    }

}
