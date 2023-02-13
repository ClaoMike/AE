package objects;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

import helpers.GameInfo;

public class MainPlayer extends AtomicObject {
    private Body body;

    public MainPlayer(String filename, float x, float y, World world, BodyDef.BodyType type, float density) {
        super(filename, x, y, world, type, density);
        body = getBody();
    }

    public void performAction(PlayerAction action) {
        switch (action){
            case GO_LEFT:
                if(body.getLinearVelocity().x > -GameInfo.PLAYER_MAX_SPEED) {
                    applyImpulse(-GameInfo.PLAYER_HORIZONTAL_IMPULSE,
                            0);
                }
                break;
            case GO_RIGHT:
                if(body.getLinearVelocity().x < GameInfo.PLAYER_MAX_SPEED) {
                    applyImpulse(GameInfo.PLAYER_HORIZONTAL_IMPULSE,
                            0);
                }
                break;
            default:
                System.out.println("Not implemented yet");
        }
    }

    private void applyImpulse(float x, float y) {
        Vector2 bodyPosition = body.getPosition();
        body.applyLinearImpulse(
                x,
                y,
                bodyPosition.x,
                bodyPosition.y,
                true);
    }

}