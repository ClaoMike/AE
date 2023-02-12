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

public class SimpleTile extends Sprite {
    private World world;
    private Body body;

    public SimpleTile(String textureName, World world, BodyDef.BodyType type, float x, float y) {
        super(new Texture(textureName));

        this.world = world;

        createBody(type, x, y);
        createFixture();
        setPosition();
    }

    private void createBody(BodyDef.BodyType type, float x, float y) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = type;
        bodyDef.position.set((x + getWidth() /2 )/GameInfo.PPM , (y + getHeight()/2)/GameInfo.PPM);
        body = world.createBody(bodyDef);
    }

    private PolygonShape generateShape() {
        PolygonShape shape = new PolygonShape();
//        shape.setAsBox(GameInfo.TILE_SIZE, GameInfo.TILE_SIZE);
        shape.setAsBox((getWidth()/2)/GameInfo.PPM, (getHeight()/2)/GameInfo.PPM);

        return shape;
    }

    private void createFixture() {
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = generateShape();
        fixtureDef.density = 1f;
        fixtureDef.friction = 0f;

        Fixture fixture = body.createFixture(fixtureDef);
    }

    private void setPosition() {
        setPosition(body.getPosition().x * GameInfo.PPM - getWidth() / 2,
                body.getPosition().y * GameInfo.PPM - getHeight() / 2);

//        System.out.println("Set sprite position at x: " + body.getPosition().x + " y: " + body.getPosition().y);
    }

    public void draw(SpriteBatch batch) {
        setPosition();
        batch.draw(
                this,
                getX(),
                getY()
//                getWidth(),
//                getHeight()
        );
        System.out.println("Sprite position: x: " + this.getX() + " y: " + this.getY());
        System.out.println("Body position: x: " + body.getPosition().x*GameInfo.PPM + " y: " + body.getPosition().y*GameInfo.PPM);
    }
}
