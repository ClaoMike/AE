package refactor.objects.blocks;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

import dev.clao.GameMain;
import refactor.objects.blocks.structures.Corners;
import refactor.objects.blueprints.Atom;
import refactor.objects.blueprints.CustomSprite;

public class Block extends Atom {
    public Block(GameMain game, String filepath, World world, float x, float y, boolean isSensor) {
        super(game, filepath, world, BodyDef.BodyType.StaticBody, x, y, 1, isSensor);
    }

    public Block(GameMain game, String filepath, World world, Vector2 coordinates, boolean isSensor) {
        super(game, filepath, world, BodyDef.BodyType.StaticBody, coordinates.x, coordinates.y, 1, isSensor);
    }

    public Vector2 getCornerCoordinates(Corners c) {
        float width = getSprite().getWidth();
        float height = getSprite().getHeight();

        float blockX = getSprite().getX() + width/2;
        float blockY = getSprite().getY() + height/2;

        Vector2 coordinates = null;

        switch (c) {
            case BOTTOM_LEFT:
                coordinates = new Vector2(blockX, blockY);
                break;
            case TOP_LEFT:
                coordinates = new Vector2(blockX, blockY + height);
                break;
            case TOP_RIGHT:
                coordinates = new Vector2(blockX + width, blockY + height);
                break;
            case BOTTOM_RIGHT:
                coordinates = new Vector2(blockX + width, blockY);
                break;
        }

        return coordinates;
    }

    public static Vector2 getSize(String filepath) {
        CustomSprite mock = new CustomSprite(filepath);
        Vector2 size = new Vector2(mock.getWidth(), mock.getHeight());
        mock.getTexture().dispose();

        return size;
    }

    public void dispose() {
        getSprite().getTexture().dispose();
    }


}
