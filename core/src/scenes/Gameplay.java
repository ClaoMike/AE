package scenes;

import dev.clao.GameMain;
import objects.StartPlatformGround;

public class Gameplay extends BasicScreen {
    StartPlatformGround startPlatformGround;

    public Gameplay(GameMain game) {
        super(game);
    }

    protected void showObjects() {
        startPlatformGround = new StartPlatformGround(world);
    }

    protected void drawObjects() {
        startPlatformGround.draw(game);
    }

}
