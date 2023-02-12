package screens;

import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.BodyDef;

import dev.clao.GameMain;
import helpers.GameInfo;
import objects.SimpleTile;

public class GameplayScreen extends  SimpleScreen{

    private SimpleTile simpleTile1;
    private SimpleTile simpleTile2;
    private SimpleTile simpleTile3;
    private SimpleTile simpleTile4;
    private SimpleTile simpleTile5;
    public GameplayScreen(GameMain game) {
        super(game);
    }

    @Override
    public void createObjects() {
        simpleTile1 = new SimpleTile("groundCube.png", world, BodyDef.BodyType.StaticBody, 200, 500);
        simpleTile2 = new SimpleTile("groundCube.png", world, BodyDef.BodyType.StaticBody, 300, 500);
        simpleTile3 = new SimpleTile("groundCube.png", world, BodyDef.BodyType.StaticBody, 400, 500);
        simpleTile4 = new SimpleTile("groundCube.png", world, BodyDef.BodyType.StaticBody, 500, 500);
        simpleTile5 = new SimpleTile("groundCube.png", world, BodyDef.BodyType.DynamicBody, 600, 500);
    }

    @Override
    public void drawObjects() {
        simpleTile1.draw(getBatch());
        simpleTile2.draw(getBatch());
        simpleTile3.draw(getBatch());
        simpleTile4.draw(getBatch());
        simpleTile5.draw(getBatch());

    }

    @Override
    public void updateObjects() {
        updateCameraPosition(new Vector3(simpleTile5.getX(), simpleTile5.getY(), 0));
    }
}
