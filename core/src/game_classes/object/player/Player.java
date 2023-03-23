package game_classes.object.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;

import game_classes.Constants;
import game_classes.object.CustomAnimationWithBody;
import game_classes.object.Directions;
import game_classes.object.blueprint.Atom;
import game_classes.screen.gameplay.GameUtils;

public class Player extends Atom {
    private final GameUtils utils;
    private final Constants constants;
    private int movementMultiplier = 1;
    private final PlayerInputProcessor playerInputProcessor;
    private final CustomAnimationWithBody animation;
    public boolean isMoving = false;

    public Player(GameUtils utils) {
        super(
                utils.game,
                utils.game.getConstants().PLAYER_IMAGE_FILEPATH,
                utils.world, BodyDef.BodyType.DynamicBody,
                utils.game.getConstants().PLAYER_INITIAL_POSITION,
                utils.game.getConstants().PLAYER_INITIAL_POSITION,
                1,
                utils.game.settings.getDebugMode(),
                0.4f
        );
        this.utils = utils;

        this.constants = utils.game.getConstants();

        playerInputProcessor = new PlayerInputProcessor(this);
        animation = new CustomAnimationWithBody(Constants.PLAYER_ANIMATION_FILEPATH, 0.25f, getSprite().getBody(), utils, 2, 1);
    }

    public void move(Directions direction) {
        Body body = getSprite().getBody();

        switch (direction){
            case LEFT:
                if(body.getLinearVelocity().x > -constants.PLAYER_MAXIMUM_LINEAR_VELOCITY) {
                    body.applyForceToCenter(new Vector2(-constants.PLAYER_MOVEMENT_FORCE * movementMultiplier, 0), true);
                }
                break;
            case RIGHT:
                if(body.getLinearVelocity().x < constants.PLAYER_MAXIMUM_LINEAR_VELOCITY) {
                    body.applyForceToCenter(new Vector2(constants.PLAYER_MOVEMENT_FORCE* movementMultiplier, 0), true);
                }
                break;
            case UP:
                if(body.getLinearVelocity().y < constants.PLAYER_MAXIMUM_LINEAR_VELOCITY) {
                    body.applyForceToCenter(new Vector2(0, constants.PLAYER_MOVEMENT_FORCE* movementMultiplier), true);
                }
                break;
            case DOWN:
                if(body.getLinearVelocity().y > -constants.PLAYER_MAXIMUM_LINEAR_VELOCITY) {
                    body.applyForceToCenter(new Vector2(0, -constants.PLAYER_MOVEMENT_FORCE* movementMultiplier), true);
                }
                break;
        }
    }

    public void stopMoving(Directions direction) {
        Body body = getSprite().getBody();

        switch (direction){
            case LEFT:
            case RIGHT:
                body.setLinearVelocity(0, body.getLinearVelocity().y);
                break;
            case UP:
            case DOWN:
                body.setLinearVelocity(body.getLinearVelocity().x, 0);
                break;
        }
    }

    public void dispose() {
        getSprite().dispose();
    }

    public void pauseMovement() {
        movementMultiplier = 0;
        Body body = getSprite().getBody();
        body.setLinearVelocity(0, 0);
    }

    public void setInputProcessorToPlayer() {
        Gdx.input.setInputProcessor(playerInputProcessor);
    }

    @Override
    public void draw() {
        if(isMoving){
            animation.draw();
        } else {
            super.draw();
        }
    }

    @Override
    public void updatePosition() {
        super.updatePosition();
        animation.updatePosition();
    }
}
