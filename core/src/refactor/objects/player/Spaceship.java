package refactor.objects.player;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

import dev.clao.GameMain;
import helpers.GameInfo;
import refactor.objects.blueprints.Atom;
import refactor.objects.blueprints.CustomSpriteWithBody;

public class Spaceship extends Atom {
    public Spaceship(GameMain game, World world, float x, float y) {
        super(game, game.getConstants().SPACESHIP_IMAGE_FILEPATH, world, BodyDef.BodyType.StaticBody, x, y, 1, false);
    }

    @Override
    public void updatePosition() {
        CustomSpriteWithBody s = getSprite();
        Body b = s.getBody();
        getSprite().setPosition(b.getPosition().x * GameInfo.PPM - s.getWidth()/3, b.getPosition().y * GameInfo.PPM - s.getHeight()/3);
    }
}
