package refactor.objects;

import static refactor.objects.Directions.LEFT;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

import java.util.Vector;

import dev.clao.GameMain;
import helpers.GameInfo;
import refactor.Constants;

public class Player extends Atom {
    private Constants constants;

    public Player(GameMain game, World world) {
        super(
                game,
                game.getConstants().PLAYER_IMAGE_FILEPATH,
                world, BodyDef.BodyType.DynamicBody,
                game.getConstants().PLAYER_INITIAL_POSITION,
                game.getConstants().PLAYER_INITIAL_POSITION,
                1,
                false
        );

        this.constants = game.getConstants();

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

}
