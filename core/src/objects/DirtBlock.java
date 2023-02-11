package objects;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

import dev.clao.GameMain;
import helpers.GameInfo;

public class DirtBlock {
    private final String textureName = "groundCube.png";
    private final BodyDef.BodyType bodyType= BodyDef.BodyType.StaticBody;
    private final int n = 2;
    private final float blockSize = 400;

    private Array<GameObject> ground = new Array<>();
    private float x;
    private float y;
    private World world;

    public DirtBlock(World world, float x, float y) {
        this.world = world;
        this.x = x;
        this.y = y;

        int j = 0;
        for (int i=0; i<n; i++) {
            GameObject goBottom = new GameObject(textureName, world, bodyType, x + j * GameInfo.TILE_SIZE, y);
            GameObject goTop = new GameObject(textureName, world, bodyType, x + j * GameInfo.TILE_SIZE, y + GameInfo.TILE_SIZE*2);

            ground.add(goBottom);
            ground.add(goTop);
            j += 2;
        }
    }

    public void draw(GameMain game) {
        for (GameObject go: ground) {
            go.draw(game.getBatch());
        }
    }

    public float getSize() {
        return blockSize;
    }
}
