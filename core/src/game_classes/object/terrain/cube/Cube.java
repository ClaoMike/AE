package game_classes.object.terrain.cube;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

import game_classes.Constants;
import game_classes.object.terrain.block.Block;
import game_classes.object.terrain.block.BlockTypes;
import game_classes.object.terrain.block.dirt.DirtSprite;
import game_classes.object.terrain.block.dirtAndSnow.DSDownSprite;
import game_classes.object.terrain.block.dirtAndSnow.DSLeftSprite;
import game_classes.object.terrain.block.dirtAndSnow.DSRightSprite;
import game_classes.object.terrain.block.dirtAndSnow.DSUpSprite;
import game_classes.object.terrain.block.dirtAndSnowCorner.DSBottomLeftCornerSprite;
import game_classes.object.terrain.block.dirtAndSnowCorner.DSBottomRightCornerSprite;
import game_classes.object.terrain.block.dirtAndSnowCorner.DSTopLeftCornerSprite;
import game_classes.object.terrain.block.dirtAndSnowCorner.DSTopRightCornerSprite;
import game_classes.object.terrain.block.snow.SnowBlock;
import game_classes.object.terrain.block.snow.SnowSprite;
import game_classes.object.blueprint.CustomSprite;
import game_classes.screen.gameplay.GameUtils;

public class Cube {
    private final GameUtils utils;
    private final Array<CustomSprite> sprites = new Array<>();
    private final Array<Block> blocks = new Array<>();

    public Cube(BlockTypes[][] arrangement, Vector2 coordinates, GameUtils utils) {
        this.utils = utils;

        Vector2 nextCoordinates = coordinates.cpy();
        for(int i = 0; i < arrangement.length; i++) {
            nextCoordinates.x = coordinates.x;
            nextCoordinates.y = coordinates.y - Constants.BLOCK_SIZE * i;
            for(int j = 0; j < arrangement[i].length; j++) {

                nextCoordinates.x = coordinates.x + Constants.BLOCK_SIZE * j;

                switch (arrangement[i][j]) {
                    case SNOW_BODY:
                        blocks.add(new SnowBlock(utils, nextCoordinates));
                        break;
                    case SNOW_SPRITE:
                        sprites.add(new SnowSprite(nextCoordinates));
                        break;
                    case DIRT_SPRITE:
                        sprites.add(new DirtSprite(nextCoordinates));
                        break;
                    case DIRT_SNOW_UP:
                        sprites.add(new DSUpSprite(nextCoordinates));
                        break;
                    case DIRT_SNOW_DOWN:
                        sprites.add(new DSDownSprite(nextCoordinates));
                        break;
                    case DIRT_SNOW_LEFT:
                        sprites.add(new DSLeftSprite(nextCoordinates));
                        break;
                    case DIRT_SNOW_RIGHT:
                        sprites.add(new DSRightSprite(nextCoordinates));
                        break;
                    case DIRT_SNOW_CORNER_TOP_LEFT:
                        sprites.add(new DSTopLeftCornerSprite(nextCoordinates));
                        break;
                    case DIRT_SNOW_CORNER_TOP_RIGHT:
                        sprites.add(new DSTopRightCornerSprite(nextCoordinates));
                        break;
                    case DIRT_SNOW_CORNER_BOTTOM_LEFT:
                        sprites.add(new DSBottomLeftCornerSprite(nextCoordinates));
                        break;
                    case DIRT_SNOW_CORNER_BOTTOM_RIGHT:
                        sprites.add(new DSBottomRightCornerSprite(nextCoordinates));
                        break;
                }

            }
        }
    }

    public void draw() {
        for(CustomSprite sprite : sprites) {
            utils.game.getBatch().draw(sprite, sprite.getX(), sprite.getY());
        }
        for(Block block: blocks) {
            block.draw();
        }
    }

    public void updatePosition() {
        for(Block block: blocks) {
            block.updatePosition();
        }
    }

    public void dispose() {
        for(CustomSprite sprite : sprites) {
            sprite.dispose();
        }
        for(Block block: blocks) {
            block.dispose();
        }
    }

}