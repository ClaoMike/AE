package refactor.objects;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;

import helpers.GameInfo;

public class CustomSpriteWithBody extends CustomSprite {
    private Body body;

    public CustomSpriteWithBody(String filepath, Body body) {
        super(filepath);
        this.body = body;
    }

    public Body getBody() {
        return body;
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

class CustomSpriteWithBodyAndShape extends CustomSpriteWithBody {

    public CustomSpriteWithBodyAndShape(String filepath, Body body, Shape shape) {
        super(filepath, body);
    }
}