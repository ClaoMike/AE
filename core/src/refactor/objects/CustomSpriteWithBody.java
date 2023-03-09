package refactor.objects;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;

import helpers.GameInfo;

public class CustomSpriteWithBody extends CustomSprite {
    private final Body body;
    private PolygonShape shape;

    public CustomSpriteWithBody(String filepath, Body body) {
        super(filepath);
        this.body = body;
    }

    public Body getBody() {
        return body;
    }

    public void generatePolygonShape() {
        shape = new PolygonShape();
        shape.setAsBox(getWidth() / 2 / GameInfo.PPM, getHeight() / 2 / GameInfo.PPM);
    }

    public Shape getShape() {
        return shape;
    }

    public void disposeShape() {
        shape.dispose();
    }

    public static Body generateBody(World world, BodyDef.BodyType type, float x, float y, ObjectUserData userData) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = type;
        bodyDef.position.set(x / GameInfo.PPM, y / GameInfo.PPM);

        Body body = world.createBody(bodyDef);
        body.setUserData(userData);

        return body;
    }
}