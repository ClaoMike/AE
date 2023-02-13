package objects.player;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

import helpers.GameInfo;
import objects.AtomicObject;

public class MainPlayer extends AtomicObject {
    private final Body body;

    public MainPlayer(String filename, float x, float y, World world, BodyDef.BodyType type, float density) {
        super(filename, x, y, world, type, density);
        body = getBody();
    }

    public void performAction(PlayerAction action) {
        switch (action){
            case GO_LEFT:
                if(body.getLinearVelocity().x > -GameInfo.PLAYER_MAX_SPEED) {
                    applyImpulse(-GameInfo.PLAYER_HORIZONTAL_IMPULSE, 0);
                }
                break;
            case GO_RIGHT:
                if(body.getLinearVelocity().x < GameInfo.PLAYER_MAX_SPEED) {
                    applyImpulse(GameInfo.PLAYER_HORIZONTAL_IMPULSE, 0);
                }
                break;
            case GO_UP:
                // TODO: update this based on collisions with walls and maximum speed
                applyImpulse(0, GameInfo.PLAYER_HORIZONTAL_IMPULSE);
                break;
            case GO_DOWN:
                // TODO: update this based on collisions with walls and maximum speed
                applyImpulse(0, -GameInfo.PLAYER_HORIZONTAL_IMPULSE);
                break;
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
