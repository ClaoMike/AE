package scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.physics.box2d.BodyDef;

import dev.clao.GameMain;
import objects.GameObject;
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
    }

    protected void drawObjects() {
        startPlatformGround.draw(game);
        player.draw(game);
    }

}
