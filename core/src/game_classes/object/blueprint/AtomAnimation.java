package game_classes.object.blueprint;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Shape;
import game_classes.Constants;
import game_classes.object.CustomAnimationWithBody;
import game_classes.screen.gameplay.GameUtils;

public class AtomAnimation {
    protected final CustomAnimationWithBody animation;

    public AtomAnimation(String filepath, BodyDef.BodyType bodyType, float x, float y, float density, boolean isSensor, float radius, float frameDuration, int FRAME_COLS, int FRAME_ROWS, GameUtils utils) {
        Body body = PhysicsTools.generateBody(utils.world, bodyType, x, y, Constants.removePNGExtension(filepath));
        animation = new CustomAnimationWithBody(filepath, frameDuration, body, utils, FRAME_COLS, FRAME_ROWS);

        Shape shape;

        if(radius > 0) {
            shape = PhysicsTools.generateCircleShape(radius);
        } else {
            shape = PhysicsTools.generatePolygonShape(animation.getWidth()/FRAME_COLS, animation.getHeight()/FRAME_ROWS);
        }

        FixtureDef fixtureDef = PhysicsTools.generateFixtureDef(shape, density, isSensor);

        animation.attachFixture(fixtureDef);
        shape.dispose();
    }

    public void draw() {
        animation.draw();
    }

    public void dispose() {
        animation.dispose();
    }

}
