package refactor.screens.gameplay;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

import dev.clao.GameMain;

public class GameUtils {
    public GameMain game;
    public World world;

    public GameUtils(GameMain game, World world)  {
        this.game = game;
        this.world = world;
    }
}
