package objects;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

import helpers.GameInfo;

public class GameObject extends Sprite {
    private String textureName;
    private Texture texture;
    private Body body;
    private World world;

    public GameObject(String textureName, World world, BodyDef.BodyType type, float initialX, float initialY) {
        this.textureName = textureName;
        this.world = world;

        texture = new Texture(textureName);

        BodyDef bodyDef = new BodyDef();
        bodyDef.type = type;
        bodyDef.position.set(initialX/ GameInfo.PPM , initialY/GameInfo.PPM);

        body = world.createBody(bodyDef);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(100/GameInfo.PPM, 100/GameInfo.PPM);

// Create a fixture definition to apply our shape to
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 0.5f;
        fixtureDef.friction = 0.4f;
//        fixtureDef.restitution = 0.6f; // Make it bounce a little bit

// Create our fixture and attach it to the body
        Fixture fixture = body.createFixture(fixtureDef);

// Remember to dispose of any shapes after you're done with them!
// BodyDef and FixtureDef don't need disposing, but shapes do.
        shape.dispose();
    }

}
