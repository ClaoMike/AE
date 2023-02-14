package objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;

import helpers.GameInfo;

public class AtomicObject extends Sprite {
    private Body body;

    public AtomicObject(String filename, float x, float y, World world, BodyDef.BodyType type, float density, boolean isCircle, boolean isSensor) {
        super(new Texture(Gdx.files.internal(filename)));

        createBody(x, y, type, world);
        setUserData(removeFileExtension(filename));
        Shape shape = createShape(isCircle);
        createFixture(shape, density, isSensor);


    }

    public void updatePosition() {
        setPosition(
                (body.getPosition().x - getWidth() / 2) * GameInfo.PPM,
                (body.getPosition().y - getHeight() / 2) * GameInfo.PPM);
        setRotation((float)Math.toDegrees(body.getAngle()));
    }

    public Body getBody() {
        return body;
    }

    public void dispose() {
        getTexture().dispose();
    }

    private void createBody(float x, float y, BodyDef.BodyType type, World world) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = type;
        bodyDef.position.set(x / GameInfo.PPM, y / GameInfo.PPM);
        body = world.createBody(bodyDef);
        body.setUserData("lol");
    }

    private Shape createShape(boolean isCircleShape) {
        if(isCircleShape) {
            CircleShape shape = new CircleShape();
            shape.setRadius(GameInfo.CIRCLE_SHAPE_RADIUS);
            return shape;
        } else {
            PolygonShape shape = new PolygonShape();
            shape.setAsBox(getWidth() / 2 / GameInfo.PPM, getHeight() / 2 / GameInfo.PPM);
            return shape;
        }
    }

    private void createFixture(Shape shape, float density, boolean isSensor) {
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = density;
        fixtureDef.isSensor = isSensor;

        body.createFixture(fixtureDef);
        shape.dispose();
    }

    private void setUserData(String userData) {
        body.setUserData(userData);
    }

    private String removeFileExtension(String filename) {
        return filename.replaceAll(".png", "");
    }
}
