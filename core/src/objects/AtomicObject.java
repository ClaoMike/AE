package objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

import helpers.GameInfo;

public class AtomicObject extends Sprite {
    private Body body;

    public AtomicObject(String filename, float x, float y, World world, BodyDef.BodyType type, float density) {
        super(new Texture(Gdx.files.internal(filename)));

        BodyDef bodyDef = new BodyDef();
        bodyDef.type = type;
        bodyDef.position.set(x / GameInfo.PPM, y / GameInfo.PPM);
        body = world.createBody(bodyDef);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(getWidth() / 2 / GameInfo.PPM, getHeight() / 2 / GameInfo.PPM);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = density;

        body.createFixture(fixtureDef);

        shape.dispose();
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
}
