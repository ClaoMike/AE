package game_classes.object;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;

import game_classes.Constants;
import game_classes.object.blueprint.AtomAnimation;
import game_classes.screen.gameplay.GameUtils;

public class Satellite extends AtomAnimation {
    public Satellite(Vector2 coordinates, GameUtils utils) {
        super(Constants.SATELLITE_IMAGE_FILEPATH, BodyDef.BodyType.StaticBody, coordinates.x, coordinates.y, 100, false, 0, 1f, 2, 1, utils);
    }

    public void updatePosition() {
        animation.updatePosition((animation.getBody().getPosition().x - 1) * Constants.PPM, (animation.getBody().getPosition().y - 1) * Constants.PPM);
    }
}
