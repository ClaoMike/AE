package refactor.objects.blocks;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

import dev.clao.GameMain;
import refactor.objects.Directions;

public class BigBlockWithWalls extends StructureOfBlocks {
    private Directions[] wallDirections;

    public BigBlockWithWalls(GameMain game, World world, Vector2 coordinates, Directions[] wallDirections) {
        super(game, world, coordinates);

        this.wallDirections = wallDirections;
        addWalls();
        addDirt();


    }

    private void addWalls() {
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

    private void addDirt() {
        if( wallDirections != null) {
            if(wallDirections.length == 4) {
                blocks.addAll(
                        new Block(game, game.getConstants().BLOCK_DIRT_IMAGE_FILEPATH, this.world, new Vector2(coordinates.x + this.blockSize.x, coordinates.y + this.blockSize.y ), false),
                        new Block(game, game.getConstants().BLOCK_DIRT_IMAGE_FILEPATH, this.world, new Vector2(coordinates.x + this.blockSize.x*2, coordinates.y + this.blockSize.y ), false),
                        new Block(game, game.getConstants().BLOCK_DIRT_IMAGE_FILEPATH, this.world, new Vector2(coordinates.x + this.blockSize.x, coordinates.y + this.blockSize.y *2), false),
                        new Block(game, game.getConstants().BLOCK_DIRT_IMAGE_FILEPATH, this.world, new Vector2(coordinates.x + this.blockSize.x * 2, coordinates.y + this.blockSize.y *2), false)
                );
            }
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
