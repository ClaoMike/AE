package objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

import dev.clao.GameMain;

public class MainPlayer extends GameObject {
    private World world;
    public boolean isInAir;

    public MainPlayer(World world) {
        super("player.png", world, BodyDef.BodyType.DynamicBody, 700, 700);
        this.world = world;
        isInAir = true;
    }

    public void draw(GameMain game) {
        super.draw(game.getBatch());
        update();
    }

    private void update() {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            moveLeft();
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            moveRight();
        } else if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            jump();
        } else if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            moveUp();
        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            moveDown();
        }
    }

    private void moveLeft() {
        float speed = body.getLinearVelocity().x;
        if(speed > -5f) {
            body.applyLinearImpulse(-0.3f, 0, body.getPosition().x, body.getPosition().y, true);
        }
    }

    private void moveRight() {
        float speed = body.getLinearVelocity().x;
        if(speed < 5f) {
            body.applyLinearImpulse(0.3f, 0, body.getPosition().x, body.getPosition().y, true);
        }
    }

    private void moveUp() {
        // TODO
        System.out.println("Move Up");
    }

    private void moveDown() {
        // TODO
        System.out.println("Move Down");
    }

    private void jump() {
        // TODO: Improve this as sometimes it does not work, check collisons
        if(!isInAir){
            body.applyLinearImpulse(0, 6f, body.getPosition().x, body.getPosition().y, true);
        }
    }

}
