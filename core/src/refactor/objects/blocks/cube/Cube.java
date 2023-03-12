package refactor.objects.blocks.cube;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

import refactor.objects.blocks.Block;
import refactor.objects.blocks.cube.dirt.DirtSprite;
import refactor.objects.blocks.cube.dirtAndSnow.DSDownSprite;
import refactor.objects.blocks.cube.dirtAndSnow.DSLeftSprite;
import refactor.objects.blocks.cube.dirtAndSnow.DSRightSprite;
import refactor.objects.blocks.cube.dirtAndSnow.DSUpSprite;
import refactor.objects.blocks.cube.dirtAndSnowCorner.DSBottomLeftCornerSprite;
import refactor.objects.blocks.cube.dirtAndSnowCorner.DSBottomRightCornerSprite;
import refactor.objects.blocks.cube.dirtAndSnowCorner.DSTopLeftCornerSprite;
import refactor.objects.blocks.cube.dirtAndSnowCorner.DSTopRightCornerSprite;
import refactor.objects.blocks.cube.snow.SnowBlock;
import refactor.objects.blocks.cube.snow.SnowSprite;
import refactor.objects.blueprints.CustomSprite;
import refactor.screens.gameplay.GameUtils;

public class Cube {
    private GameUtils utils;
    private Array<CustomSprite> sprites = new Array<>();
    private Array<Block> blocks = new Array<>();

    public Cube(BlockTypes[][] arrangement, Vector2 coordinates, GameUtils utils) {
        this.utils = utils;

        Vector2 nextCoordinates = coordinates.cpy();
        for(int i = 0; i < arrangement.length; i++) {
            nextCoordinates.x = coordinates.x;
            nextCoordinates.y = coordinates.y - 100 * i;
            for(int j = 0; j < arrangement[i].length; j++) {

                nextCoordinates.x = coordinates.x + 100 * j;

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