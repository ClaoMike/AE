package refactor.objects.spaceship;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;

import refactor.Constants;
import refactor.objects.blueprints.Atom;
import refactor.objects.blueprints.CustomSpriteWithBody;
import refactor.screens.gameplay.GameUtils;

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
}
