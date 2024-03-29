package game_classes.object.terrain.platform;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import game_classes.Constants;
import game_classes.object.Directions;
import game_classes.object.terrain.cube.Cube;
import game_classes.object.terrain.cube.CubeArrangements;
import game_classes.screen.gameplay.GameUtils;

public class Platform {
    private final GameUtils utils;
    private final Array<Cube> cubes = new Array<>();
    private final float endX;
    private final float startX;
    private final float startY;

    public Platform(Vector2 coordinates, int cubesCount, Directions directions, GameUtils utils) {
        this.utils = utils;
        this.endX = coordinates.x + cubesCount * 4 * Constants.BLOCK_SIZE;
        this.startX = coordinates.x;
        this.startY = coordinates.y;

        Vector2 nextCoordinates = coordinates.cpy();
        if(directions == Directions.LEFT) {
            for(int i = 0; i < cubesCount; i++) {
                addRoad(nextCoordinates);
                addSnowBorders(nextCoordinates);

                nextCoordinates.x += 4 * Constants.BLOCK_SIZE;
            }
            addConnection(nextCoordinates, directions);
            addSnowBorders(nextCoordinates);
        }
        else if( directions == Directions.RIGHT) {
            addConnection(nextCoordinates, directions);
            addSnowBorders(nextCoordinates);

            for(int i = 0; i < cubesCount; i++) {
                nextCoordinates.x += 4 * Constants.BLOCK_SIZE;
                addRoad(nextCoordinates);
                addSnowBorders(nextCoordinates);
            }

        }

    }

    private void addRoad(Vector2 coordinates) {
        cubes.add(new Cube(CubeArrangements.Platform.road, coordinates, utils)); // Road
    }

    private void addSnowBorders(Vector2 coordinates) {
        Vector2 newCoordinates = new Vector2(coordinates.x, coordinates.y - 400);

        cubes.add(new Cube(CubeArrangements.Platform.borderDown, newCoordinates, utils));

        newCoordinates = new Vector2(coordinates.x, coordinates.y + 400);
        cubes.add(new Cube(CubeArrangements.Platform.borderUp, newCoordinates, utils));// snow
    }

    private void addConnection(Vector2 coordinates, Directions direction) {
        if(Directions.RIGHT == direction)
            cubes.add(new Cube(CubeArrangements.Connection.leftArrangement, coordinates, utils));
        else if(Directions.LEFT == direction)
            cubes.add(new Cube(CubeArrangements.Connection.rightArrangement, coordinates, utils));
    }

    public void draw() {
        for (Cube c: cubes) {
            c.draw();
        }
    }

    public void dispose() {
        for (Cube c: cubes) {
            c.dispose();
        }
    }

    public void updatePosition() {
        for (Cube c: cubes) {
            c.updatePosition();
        }
    }

    public float getEndX() {
        return endX;
    }



    public Vector2 getMiddleCoordinates() {
        return new Vector2(startX + (endX - startX)/2, startY - 1.5f * Constants.BLOCK_SIZE);
    }

}
