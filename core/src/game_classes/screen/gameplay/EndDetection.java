package game_classes.screen.gameplay;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;

import game_classes.Constants;

public class EndDetection implements ContactListener {
    private GameUtils utils;

    public EndDetection(GameUtils utils) {
        this.utils = utils;
        utils.world.setContactListener(this);
    }

    @Override
    public void beginContact(Contact contact) {
        String playerID = Constants.removePNGExtension(utils.game.getConstants().PLAYER_IMAGE_FILEPATH);
        String sensorID = utils.game.getConstants().END_SENSOR_NAME;

        String c1 = contact.getFixtureA().getBody().getUserData().toString();
        String c2 = contact.getFixtureB().getBody().getUserData().toString();

        if(c1.equals(sensorID) && c2.equals(playerID) || c1.equals(playerID) && c2.equals(sensorID)) {
            System.out.println("Contact between " + c1 + " and " + c2);
            //TODO:
            // 1. stop movement;
            // 2. create the end menu;
            // 3. display the end menu;
        }
    }

    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}
