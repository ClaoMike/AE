package gameObjects.staticObjects;

import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

import dev.clao.GameMain;
import helpers.GameInfo;

public class WorldTerrainController {
    private GameMain game;
    private World world;
    private Array<GroundTile> groundTiles = new Array<>();

    public WorldTerrainController(GameMain game, World world) {
        this.game = game;
        this.world = world;

        createStartingTerrain();
    }

    private void createStartingTerrain() {
        int numberOfStartTiles = GameInfo.WIDTH / GameInfo.TILE_SIZE;
        for(int i=0; i<numberOfStartTiles; i++) {
            GroundTile gt = new GroundTile(world);
            gt.setSpritePosition(i*GameInfo.TILE_SIZE, 0);
            groundTiles.add(gt);
        }
    }

    public void drawTerrain() {
        for(GroundTile gt: groundTiles){
            game.getBatch().draw(gt, gt.getX(), gt.getY());
        }

    }
}
