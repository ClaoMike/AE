package game_classes.object.blueprint;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Shape;

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
        shape = PhysicsTools.generatePolygonShape(getWidth(), getHeight());
    }

    public void generateCircleShape(float radius) {
        shape = PhysicsTools.generateCircleShape(radius);
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
}