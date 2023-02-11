package scenes;

import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;

import dev.clao.GameMain;
import objects.MainPlayer;
import objects.StartPlatformGround;

public class Gameplay extends BasicScreen {
    StartPlatformGround startPlatformGround;
    MainPlayer player;

    public Gameplay(GameMain game) {
        super(game);
    }

    protected void showObjects() {
        startPlatformGround = new StartPlatformGround(world);
        player = new MainPlayer(world);
        createCollisionListener();
    }

    protected void drawObjects() {
        startPlatformGround.draw(game);
        player.draw(game);
    }

    private void createCollisionListener() {
        world.setContactListener(new ContactListener() {
            @Override
            public void beginContact(Contact contact) {
                Fixture fixtureA = contact.getFixtureA();
                Fixture fixtureB = contact.getFixtureB();

                if (fixtureA.getUserData().equals("player") || fixtureB.getUserData().equals("player") ) {
                    player.isInAir = false;
                }
            }

            @Override
            public void endContact(Contact contact) {
                Fixture fixtureA = contact.getFixtureA();
                Fixture fixtureB = contact.getFixtureB();

                if (fixtureA.getUserData().equals("player") || fixtureB.getUserData().equals("player") ) {
                    player.isInAir = true;
                }
            }

            @Override
            public void preSolve(Contact contact, Manifold oldManifold) {
            }

            @Override
            public void postSolve(Contact contact, ContactImpulse impulse) {
            }

        });
    }

    protected Vector3 getCameraNewPosition() {
        return new Vector3(player.getBody().getPosition().x, player.getBody().getPosition().y,0);
    }

}
