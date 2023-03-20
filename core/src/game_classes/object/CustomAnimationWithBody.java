package game_classes.object;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.FixtureDef;

import game_classes.Constants;
import game_classes.screen.gameplay.GameUtils;

public class CustomAnimationWithBody extends CustomAnimation {
    private final Body body;

    public CustomAnimationWithBody(String filepath, float frameDuration, Body body, GameUtils utils) {
        super(filepath, frameDuration, utils);
        this.body = body;
    }

    public void attachFixture(FixtureDef fixtureDef) {
        body.createFixture(fixtureDef);
    }

    public void updatePosition() {
        // TODO: update this accordingly
        updatePosition(body.getPosition().x * Constants.PPM, body.getPosition().y * Constants.PPM);
//        updatePosition(body.getPosition().x * Constants.PPM + getTexture().getWidth()/4, body.getPosition().y * Constants.PPM + getTexture().getHeight()/4);

    }


}
