package objects.gameplay.player;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;

public class PlayerContactListener implements ContactListener {

    public PlayerContactListener(MainPlayer player) {
    }

    @Override
    public void beginContact(Contact contact) {
//        String s1 = contact.getFixtureA().getBody().getUserData().toString();
//        String s2 = contact.getFixtureB().getBody().getUserData().toString();
//
//        System.out.println("Collision detected between " + s1 + " and " + s2);
//
//        if(s1.equals("dirt") && s2.equals("player") || s1.equals("player") && s2.equals("dirt")) {
//            WorldManifold worldManifold = contact.getWorldManifold();
//            Vector2 collisionNormal = worldManifold.getNormal();
//
//            // use the collision normal to determine the direction of the collision
//            if (collisionNormal.y > 0) {
//                // collision from the top
//                System.out.println("Collision from the bottom");
//            } else if (collisionNormal.y < 0) {
//                // collision from the bottom
//                System.out.println("Collision from the top");
//            } else if (collisionNormal.x > 0) {
//                // collision from the left
//                System.out.println("Collision from the left");
//            } else if (collisionNormal.x < 0) {
//                // collision from the right
//                System.out.println("Collision from the right");
//            }
//        }
    }

    @Override
    public void endContact(Contact contact) {
        // called when two objects stop colliding
//        System.out.println("no collision");

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
