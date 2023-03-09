package refactor;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

import dev.clao.GameMain;
import refactor.objects.Atom;

public class Player extends Atom {

    public Player(GameMain game, World world) {
        super(
                game,
                game.getConstants().PLAYER_IMAGE_FILEPATH,
                world, BodyDef.BodyType.DynamicBody,
                game.getConstants().PLAYER_INITIAL_POSITION,
                game.getConstants().PLAYER_INITIAL_POSITION,
                1,
                false
        );
    }
}
