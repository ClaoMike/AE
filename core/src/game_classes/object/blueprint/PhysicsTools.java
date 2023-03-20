package game_classes.object.blueprint;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;

import game_classes.Constants;

public class PhysicsTools {
    public static PolygonShape generatePolygonShape(float width, float height) {
        PolygonShape s = new PolygonShape();
        s.setAsBox(width / 2 / Constants.PPM, height / 2 / Constants.PPM);

        return s;
    }

    public static CircleShape generateCircleShape(float radius) {
        CircleShape s = new CircleShape();
        s.setRadius(radius);

        return s;
    }

    public static Body generateBody(World world, BodyDef.BodyType type, float x, float y, String userData) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = type;
        bodyDef.position.set(x / Constants.PPM, y / Constants.PPM);

        Body body = world.createBody(bodyDef);
        body.setUserData(userData);

        return body;
    }

    public static FixtureDef generateFixtureDef(Shape shape, float density, boolean isSensor) {
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = density;
        fixtureDef.isSensor = isSensor;

        return fixtureDef;
    }

}
