package refactor.objects;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;

import dev.clao.GameMain;

public class Atom {
    private final CustomSpriteWithBody sprite;
    private final GameMain game;

    public Atom(GameMain game, String filepath, World world, BodyDef.BodyType bodyType, float x, float y, float density, boolean isSensor) {
        this.game = game;

        ObjectUserData userData = new ObjectUserData(removePNGExtension(filepath));
        Body body = CustomSpriteWithBody.generateBody(world, bodyType, x, y, userData);

        sprite = new CustomSpriteWithBody(filepath, body);
        sprite.generatePolygonShape();

        FixtureDef fixtureDef = CustomSpriteWithBody.generateFixtureDef(sprite.getShape(), density, isSensor);

        sprite.attachFixture(fixtureDef);
        sprite.updatePositionToBody();
    }

    public void updatePosition() {
        sprite.updatePositionToBody();
    }

    public void draw() {
        game.getBatch().draw(sprite, sprite.getX(), sprite.getY());
    }

    public CustomSpriteWithBody getSprite() {
        return sprite;
    }

    private String removePNGExtension(String filename) {
        return filename.replaceAll(game.getConstants().PNG_EXTENSION, game.getConstants().EMPTY_STRING);
    }
}