package game_classes.object.blueprint;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Shape;
import game_classes.Constants;
import game_classes.object.CustomAnimationWithBody;
import game_classes.screen.gameplay.GameUtils;

public class AtomAnimation {
    private CustomAnimationWithBody animation;

    public AtomAnimation(String filepath, BodyDef.BodyType bodyType, float x, float y, float density, boolean isSensor, float radius, float frameDuration, GameUtils utils) {
        Body body = PhysicsTools.generateBody(utils.world, bodyType, x, y, Constants.removePNGExtension(filepath));
        animation = new CustomAnimationWithBody(filepath, frameDuration, body, utils);

        Shape shape;

        if(radius > 0) {
            shape = PhysicsTools.generateCircleShape(radius);
        } else {
            shape = PhysicsTools.generatePolygonShape(animation.getWidth(), animation.getHeight());
        }

        FixtureDef fixtureDef = PhysicsTools.generateFixtureDef(shape, density, isSensor);

        animation.attachFixture(fixtureDef);
        shape.dispose();
    }

    public void draw() {
        animation.draw();
    }

    public void updatePosition() {
        animation.updatePosition();
    }

    public void dispose() {
        animation.dispose();
    }

}
