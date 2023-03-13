package game_classes.object.blueprint;

import com.badlogic.gdx.math.Vector2;

public class UpdatedCustomSprite extends CustomSprite {

    public UpdatedCustomSprite(String filepath, Vector2 coordinates) {
        super(filepath);
        setPosition(coordinates.x, coordinates.y);
    }
}