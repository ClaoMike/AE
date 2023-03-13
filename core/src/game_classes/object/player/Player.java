package game_classes.object.player;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;

import game_classes.Constants;
import game_classes.object.Directions;
import game_classes.object.blueprint.Atom;
import game_classes.screen.gameplay.GameUtils;

public class Player extends Atom {
    private final Constants constants;
    private int movementMultiplier;

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

        this.constants = utils.game.getConstants();

        new PlayerInputProcessor(this);
    }

    public void move(Directions direction) {
        Body body = getSprite().getBody();

        switch (direction){
            case LEFT:
                if(body.getLinearVelocity().x > -constants.PLAYER_MAXIMUM_LINEAR_VELOCITY) {
                    body.applyForceToCenter(new Vector2(-constants.PLAYER_MOVEMENT_FORCE, 0), true);
                }
                break;
            case RIGHT:
                if(body.getLinearVelocity().x < constants.PLAYER_MAXIMUM_LINEAR_VELOCITY) {
                    body.applyForceToCenter(new Vector2(constants.PLAYER_MOVEMENT_FORCE, 0), true);
                }
                break;
            case UP:
                if(body.getLinearVelocity().y < constants.PLAYER_MAXIMUM_LINEAR_VELOCITY) {
                    body.applyForceToCenter(new Vector2(0, constants.PLAYER_MOVEMENT_FORCE), true);
                }
                break;
            case DOWN:
                if(body.getLinearVelocity().y > -constants.PLAYER_MAXIMUM_LINEAR_VELOCITY) {
                    body.applyForceToCenter(new Vector2(0, -constants.PLAYER_MOVEMENT_FORCE), true);
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

}
