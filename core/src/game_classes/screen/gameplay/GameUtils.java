package game_classes.screen.gameplay;

import com.badlogic.gdx.physics.box2d.World;

import dev.clao.GameMain;

public class GameUtils {
    public final GameMain game;
    public final World world;

    public GameUtils(GameMain game, World world)  {
        this.game = game;
        this.world = world;
    }
}
