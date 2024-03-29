package game_classes.object;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.FixtureDef;

import game_classes.Constants;
import game_classes.screen.gameplay.GameUtils;

public class CustomAnimationWithBody extends CustomAnimation {
    private final Body body;

    public CustomAnimationWithBody(String filepath, float frameDuration, Body body, GameUtils utils, int FRAME_COLS, int FRAME_ROWS) {
        super(filepath, frameDuration, utils, FRAME_COLS, FRAME_ROWS);
        this.body = body;
    }

    public void attachFixture(FixtureDef fixtureDef) {
        body.createFixture(fixtureDef);
    }

    public void updatePosition() {
        updatePosition(body.getPosition().x * Constants.PPM, body.getPosition().y * Constants.PPM);
    }

    public Body getBody() {
        return body;
    }


}
