package game_classes.object.blueprint;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;

import game_classes.Constants;

public class CustomSpriteWithBody extends CustomSprite {
    private final Body body;
    private Shape shape;

    public CustomSpriteWithBody(String filepath, Body body) {
        super(filepath);
        this.body = body;
    }

    public Body getBody() {
        return body;
    }

    public void generatePolygonShape() {
        PolygonShape s = new PolygonShape();
        s.setAsBox(getWidth() / 2 / Constants.PPM, getHeight() / 2 / Constants.PPM);
        shape = s;
    }

    public void generateCircleShape(float radius) {
        CircleShape s = new CircleShape();
        s.setRadius(radius);
        shape = s;
    }

    public Shape getShape() {
        return shape;
    }

    public void disposeShape() {
        shape.dispose();
    }

    public void attachFixture(FixtureDef fixtureDef) {
        body.createFixture(fixtureDef);
        disposeShape();
    }

    public void updatePositionToBody() {
        setPosition(body.getPosition().x * Constants.PPM , body.getPosition().y * Constants.PPM );
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