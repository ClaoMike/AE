package objects.gameplay.player;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

import helpers.GameInfo;
import objects.gameplay.AtomicObject;

public class MainPlayer extends AtomicObject implements PlayerActions {
    private final Body body;
    private final PlayerInputProcessor inputProcessor;

    public MainPlayer(String filename, float x, float y, World world, BodyDef.BodyType type, float density) {
        super(filename, x, y, world, type, density, true, false);
        body = getBody();
        body.setFixedRotation(true);
        inputProcessor = new PlayerInputProcessor(this);
    }

    @Override
    public void updatePosition() {
        super.updatePosition();
        inputProcessor.detectUserInput();
    }

    public void go(Directions direction) {
        switch (direction){
            case LEFT:
                if(body.getLinearVelocity().x > -GameInfo.PLAYER_MAXIMUM_HORIZONTAL_SPEED) {
                    applyForceToTheCenterOfTheBody(-GameInfo.PLAYER_HORIZONTAL_FORCE, GameInfo.NULL_FORCE);

                }
                break;
            case RIGHT:
                if(body.getLinearVelocity().x < GameInfo.PLAYER_MAXIMUM_HORIZONTAL_SPEED) {
                    applyForceToTheCenterOfTheBody(GameInfo.PLAYER_HORIZONTAL_FORCE, GameInfo.NULL_FORCE);
                }
                break;
            case UP:
                // TODO: update this based on collisions with walls
                if(body.getLinearVelocity().y < GameInfo.PLAYER_MAXIMUM_UPWARDS_SPEED) {
                    applyForceToTheCenterOfTheBody(GameInfo.NULL_FORCE, GameInfo.PLAYER_UPWARDS_FORCE);
                }
                break;
            case DOWN:
                // TODO: update this based on collisions with walls
                applyForceToTheCenterOfTheBody(GameInfo.NULL_FORCE, GameInfo.PLAYER_DOWNWARDS_FORCE);
                break;
        }
    }

    @Override
    public void stopMoving(Directions direction) {
        switch (direction){
            case LEFT:
            case RIGHT:
                stopHorizontalMovement();
                break;
            case UP:
            case DOWN:
                stopVerticalMovement();
                break;
        }
    }

    private void applyForceToTheCenterOfTheBody(float x, float y) {
        body.applyForceToCenter(new Vector2(x, y), true);
    }

    private void stopHorizontalMovement() {
        body.setLinearVelocity(GameInfo.NULL_FORCE, body.getLinearVelocity().y);
    }

    private void stopVerticalMovement() {
        body.setLinearVelocity(body.getLinearVelocity().x, GameInfo.NULL_FORCE);
    }

}
