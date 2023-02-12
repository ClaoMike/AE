package objects;

import static helpers.GameInfo.PPM;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class AtomicObject extends Sprite {
    private Body body;

    public AtomicObject(String filename, float x, float y, World world, BodyDef.BodyType type) {
        super(new Texture(Gdx.files.internal("player.png")));

        BodyDef bodyDef = new BodyDef();
        bodyDef.type = type;
        bodyDef.position.set(x / PPM, y / PPM);
        body = world.createBody(bodyDef);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(getWidth() / 2 / PPM, getHeight() / 2 / PPM);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1.0f;

        body.createFixture(fixtureDef);

        shape.dispose();
    }

    public void updatePosition() {
        setPosition((body.getPosition().x - getWidth() / 2) * PPM, (body.getPosition().y - getHeight() / 2) * PPM);
        setRotation((float)Math.toDegrees(body.getAngle()));
    }

    public Body getBody() {
        return body;
    }

    public void dispose() {
        getTexture().dispose();
    }
}
