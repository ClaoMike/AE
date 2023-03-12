package refactor.objects.blocks.platforms;


import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

import refactor.objects.Directions;
import refactor.objects.blocks.cube.Cube;
import refactor.objects.blocks.cube.CubeArrangements;
import refactor.screens.gameplay.GameUtils;

public class Platform {
    private GameUtils utils;
    private Array<Cube> cubes = new Array<>();

    public Platform(Vector2 coordinates, int cubesCount, Directions directions, GameUtils utils) {
        this.utils = utils;

        Vector2 nextCoordinates = coordinates.cpy();
        if(directions == Directions.LEFT) {
            for(int i = 0; i < cubesCount; i++) {
                addRoad(nextCoordinates);
                addSnowBorders(nextCoordinates);

                nextCoordinates.x += 400;
            }
            addConnection(nextCoordinates, directions);
            addSnowBorders(nextCoordinates);
        }
        else if( directions == Directions.RIGHT) {
            addConnection(nextCoordinates, directions);
            addSnowBorders(nextCoordinates);

            for(int i = 0; i < cubesCount; i++) {
                nextCoordinates.x += 400;
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
            cubes.add(new Cube(CubeArrangements.Connenction.leftArrangement, coordinates, utils));
        else if(Directions.LEFT == direction)
            cubes.add(new Cube(CubeArrangements.Connenction.rightArrangement, coordinates, utils));
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

}