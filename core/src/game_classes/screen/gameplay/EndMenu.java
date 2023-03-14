package game_classes.screen.gameplay;

import static game_classes.screen.Screens.GAMEPLAY;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import dev.clao.GameMain;
import game_classes.Constants;

public class EndMenu extends GameMenu {
    public EndMenu(final GameMain game, BitmapFont font) {
        super(game, Constants.PLAY_AGAIN_STRING,  font);

        firstButton.addListener(new ChangeListener() {
            @Override
            public void changed (ChangeEvent event, Actor actor) {
                game.goToScreen(GAMEPLAY);
            }
        });
    }
}
