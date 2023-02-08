package gameObjects.dynamicObjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class MainPlayer extends Sprite {
    private World world;
    private Body body;

    public MainPlayer(World world, float initalPositionX, float initialPositionY) {
        super(new Texture("player.png"));
        this.world = world;

        setPosition(initalPositionX, initialPositionY);
        createBody();
    }

    void createBody() {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set((getX() + getWidth()/2f), (getY() + getHeight()/2));
        body = world.createBody(bodyDef);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(getWidth()/2, getHeight()/2);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 80f;

        Fixture fixture = body.createFixture(fixtureDef);

        shape.dispose();
    }

    public void update() {
        setPosition(body.getPosition().x-getWidth()/2, body.getPosition().y-getHeight()/2);
    }

}
