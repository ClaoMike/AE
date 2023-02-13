package objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

import helpers.GameInfo;

public class Platform implements Drawable{
    private final int numberOfRooms = GameInfo.NUMBER_OF_BASIC_ROOMS_IN_PLATFORM;
    private Array<BasicRoom> rooms = new Array<BasicRoom>();
    private SpriteBatch batch;
    private World world;

    public Platform(SpriteBatch batch, World world, float initialX, float initialY) {
        for (int i = 0; i < numberOfRooms; i++) {
            BasicRoom br = new BasicRoom(batch, world, initialX, initialY);
            rooms.add(br);
            initialX += br.getSize();
        }
    }

    @Override
    public void draw() {
        for(BasicRoom room : rooms) {
            room.draw();
        }
    }

    @Override
    public void updatePosition() {
        for(BasicRoom room : rooms) {
            room.updatePosition();
        }
    }

    @Override
    public void dispose() {
        for(BasicRoom room : rooms) {
            room.dispose();
        }
    }
}
