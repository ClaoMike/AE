package refactor.objects;

import com.badlogic.gdx.utils.Array;

import dev.clao.GameMain;
import refactor.objects.blueprints.CustomSprite;

public class CSpriteRow {
    Array<CustomSprite> sprites = new Array<>();
    private GameMain game;

    public CSpriteRow(GameMain game, float x, float y, int count, String filepath) {
        this.game = game;
        for(int i = 0; i < count; i++) {
            CustomSprite t = new CustomSprite(filepath);
            t.setPosition(x, y);

            x += t.getWidth();
            sprites.addAll(t);
        }
    }

    public void draw() {
        for (CustomSprite s : sprites) {
            s.draw(game.getBatch());
        }
    }
}
