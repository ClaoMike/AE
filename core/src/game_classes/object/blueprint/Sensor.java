package game_classes.object.blueprint;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import game_classes.Constants;
import game_classes.screen.gameplay.GameUtils;

public class Sensor {
    public Sensor(String sensorName, GameUtils utils, float x, float y) {
        Body body = CustomSpriteWithBody.generateBody(utils.world, BodyDef.BodyType.StaticBody, x, y, sensorName);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(Constants.BLOCK_SIZE /2 / Constants.PPM, Constants.BLOCK_SIZE / 2 / Constants.PPM * 4);

        FixtureDef fixtureDef = CustomSpriteWithBody.generateFixtureDef(shape, 0, true);
        body.createFixture(fixtureDef);

        shape.dispose();
    }
}