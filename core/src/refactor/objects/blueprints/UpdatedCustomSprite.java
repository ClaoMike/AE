package refactor.objects.blueprints;

import com.badlogic.gdx.math.Vector2;

import refactor.objects.blueprints.CustomSprite;

public class UpdatedCustomSprite extends CustomSprite {

    public UpdatedCustomSprite(String filepath, Vector2 coordinates) {
        super(filepath);
        setPosition(coordinates.x, coordinates.y);
    }
}