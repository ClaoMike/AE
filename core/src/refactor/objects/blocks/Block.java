package refactor.objects.blocks;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

import dev.clao.GameMain;
import refactor.objects.blueprints.Atom;

public class Block extends Atom {
    public Block(GameMain game, String filepath, World world, Vector2 coordinates, boolean isSensor) {
        super(game, filepath, world, BodyDef.BodyType.StaticBody, coordinates.x, coordinates.y, 1, isSensor);
    }

    public void dispose() {
        getSprite().getTexture().dispose();
    }


}
