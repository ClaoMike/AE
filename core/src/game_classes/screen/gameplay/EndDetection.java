package game_classes.screen.gameplay;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;

import game_classes.Constants;
import game_classes.object.player.Player;

public class EndDetection implements ContactListener {
    private final GameUtils utils;
    private final Player player;
    private final GameplayScreen gameplayScreen;

    public EndDetection(GameUtils utils, Player player, GameplayScreen screen) {
        this.utils = utils;
        this.player = player;
        this.gameplayScreen = screen;
        utils.world.setContactListener(this);
    }

    @Override
    public void beginContact(Contact contact) {
        String playerID = Constants.removePNGExtension(utils.game.getConstants().PLAYER_IMAGE_FILEPATH);
        String sensorID = Constants.removePNGExtension(Constants.NEW_SATELLITE_IMAGE_FILEPATH);

        String c1 = contact.getFixtureA().getBody().getUserData().toString();
        String c2 = contact.getFixtureB().getBody().getUserData().toString();

        if(c1.equals(sensorID) && c2.equals(playerID) || c1.equals(playerID) && c2.equals(sensorID)) {
            player.pauseMovement();
            gameplayScreen.showEndMenu();
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
