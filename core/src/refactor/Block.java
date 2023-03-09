package refactor;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

import dev.clao.GameMain;
import refactor.objects.Atom;

public class Block extends Atom {
    public Block(GameMain game, String filepath, World world, float x, float y, boolean isSensor) {
        super(game, filepath, world, BodyDef.BodyType.StaticBody, x, y, 1, isSensor);
    }
}
