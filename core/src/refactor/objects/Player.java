package refactor.objects;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

import dev.clao.GameMain;
import helpers.GameInfo;

public class Player extends Atom {
    private final PlayerInputProcessor playerInputProcessor;

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

        playerInputProcessor = new PlayerInputProcessor(this);
    }

    public void move(Directions direction) {
        Body body = getSprite().getBody();
        switch (direction){
            case LEFT:
                if(body.getLinearVelocity().x > -9) {
                    body.applyForceToCenter(new Vector2(-100, GameInfo.NULL_FORCE), true);
                }
                break;
            case RIGHT:
                if(body.getLinearVelocity().x < 9) {
                    body.applyForceToCenter(new Vector2(100, GameInfo.NULL_FORCE), true);
                }
                break;
            case UP:
                if(body.getLinearVelocity().y < 9) {
                    body.applyForceToCenter(new Vector2(0, 100), true);
                }
                break;
            case DOWN:
                if(body.getLinearVelocity().y > -9) {
                    body.applyForceToCenter(new Vector2(0, -100), true);
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
