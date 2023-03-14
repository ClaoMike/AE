package game_classes.object;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import game_classes.Constants;
import game_classes.object.blueprint.Atom;
import game_classes.object.blueprint.CustomSpriteWithBody;
import game_classes.screen.gameplay.GameUtils;

public class Satellite extends Atom {

    public Satellite(GameUtils utils, Vector2 coordinates) {
        super(utils.game, Constants.SATELLITE_IMAGE_FILEPATH, utils.world, BodyDef.BodyType.StaticBody, coordinates.x, coordinates.y, 1, false, 0);
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
