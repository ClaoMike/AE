package objects.player;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;

public class PlayerContactListener implements ContactListener {
    @Override
    public void beginContact(Contact contact) {
        // called when two objects begin colliding
        System.out.println("collision");
    }

    @Override
    public void endContact(Contact contact) {
        // called when two objects stop colliding
        System.out.println("no collision");

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {
        // called before a collision is resolved
    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {
        // called after a collision is resolved
    }
}
