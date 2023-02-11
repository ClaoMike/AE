package objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

import helpers.GameInfo;

public class GameObject extends Sprite {
    private World world;
    protected Body body;

    public GameObject(String textureName, World world, BodyDef.BodyType type, float initialX, float initialY) {
        super(new Texture(textureName));

        this.world = world;

        createBody(type, initialX, initialY);
        attachFixtureToBody(generateFixtureDefinition());
    }

    private void createBody(BodyDef.BodyType type, float x, float y) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = type;
        bodyDef.position.set((x + GameInfo.TILE_SIZE)/GameInfo.PPM , (y + GameInfo.TILE_SIZE)/GameInfo.PPM);
        body = world.createBody(bodyDef);
    }

    private FixtureDef generateFixtureDefinition() {
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = generateShape();
        fixtureDef.density = 0.5f;
        fixtureDef.friction = 0.4f;
//        fixtureDef.restitution = 0.6f; // Make it bounce a little bit

        return fixtureDef;
    }

    private PolygonShape generateShape() {
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(GameInfo.TILE_SIZE/GameInfo.PPM, GameInfo.TILE_SIZE/GameInfo.PPM);

        return shape;
    }

    private void attachFixtureToBody(FixtureDef fd) {
        Fixture fixture = body.createFixture(fd);
    }

    public void draw(SpriteBatch batch) {
        batch.draw(
                this,
                body.getPosition().x - this.getWidth()/GameInfo.PPM,
                body.getPosition().y - this.getHeight()/GameInfo.PPM,
                this.getWidth()*2/GameInfo.PPM,
                this.getHeight()*2/GameInfo.PPM);

    }

    public Body getBody() {
        return body;
    }

}
