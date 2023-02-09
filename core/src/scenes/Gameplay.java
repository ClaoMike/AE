package scenes;

import com.badlogic.gdx.physics.box2d.BodyDef;
import dev.clao.GameMain;
import objects.GameObject;

public class Gameplay extends BasicScreen {
    GameObject go;

    public Gameplay(GameMain game) {
        super(game);
    }

    protected void showObjects() {
        go = new GameObject("groundCube.png", world, BodyDef.BodyType.StaticBody, 500, 500);
    }

    protected void drawObjects() {
        go.draw(game.getBatch());
    }

}
