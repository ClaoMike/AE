package game_classes.object;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;

import game_classes.Constants;
import game_classes.object.blueprint.AtomAnimation;
import game_classes.screen.gameplay.GameUtils;

public class NewSatellite extends AtomAnimation {
    public NewSatellite(Vector2 coordinates, GameUtils utils) {
        super(Constants.NEW_SATELLITE_IMAGE_FILEPATH, BodyDef.BodyType.StaticBody, coordinates.x, coordinates.y, 100, false, 0, 0.25f, 2, 1, utils);
    }

    @Override
    public void updatePosition() {
        // TODO: update this accordingly
//        animation.updatePosition(animation.getBody().getPosition().x * Constants.PPM - animation.getWidth()/(animation.getWidth()/Constants.PPM), animation.getBody().getPosition().y * Constants.PPM - animation.getHeight()/3);
        animation.updatePosition((animation.getBody().getPosition().x - 1) * Constants.PPM, (animation.getBody().getPosition().y - 1) * Constants.PPM);

    }
}
