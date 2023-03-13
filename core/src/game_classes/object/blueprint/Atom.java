package game_classes.object.blueprint;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;

import dev.clao.GameMain;
import game_classes.Constants;

public class Atom {
    private final CustomSpriteWithBody sprite;
    private final GameMain game;

    public Atom(GameMain game, String filepath, World world, BodyDef.BodyType bodyType, float x, float y, float density, boolean isSensor, float radius) {
        this.game = game;

        Body body = CustomSpriteWithBody.generateBody(world, bodyType, x, y, Constants.removePNGExtension(filepath));

        sprite = new CustomSpriteWithBody(filepath, body);
        if(radius > 0) {
            sprite.generateCircleShape(radius);
        } else {
            sprite.generatePolygonShape();
        }


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


}