package game_classes.object.spaceship;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;

import game_classes.Constants;
import game_classes.object.blueprint.Atom;
import game_classes.object.blueprint.CustomSpriteWithBody;
import game_classes.screen.gameplay.GameUtils;

public class Spaceship extends Atom {
    public Spaceship(GameUtils utils, float x, float y) {
        super(utils.game, utils.game.getConstants().SPACESHIP_IMAGE_FILEPATH, utils.world, BodyDef.BodyType.StaticBody, x, y, 1, false);
    }

    @Override
    public void updatePosition() {
        CustomSpriteWithBody s = getSprite();
        Body b = s.getBody();
        getSprite().setPosition(b.getPosition().x * Constants.PPM - s.getWidth()/3, b.getPosition().y * Constants.PPM - s.getHeight()/3);
    }

    public void dispose() {
        getSprite().dispose();
    }
}
