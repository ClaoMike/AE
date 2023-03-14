package game_classes.screen.gameplay;

import static game_classes.screen.Screens.GAMEPLAY;
import static game_classes.screen.Screens.MAIN_MENU;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import dev.clao.GameMain;

public class EndMenu extends GameMenu {
    public EndMenu(final GameMain game, BitmapFont font) {
        super(game, "Play again",  font);

        firstButton.addListener(new ChangeListener() {
            @Override
            public void changed (ChangeEvent event, Actor actor) {
                game.goToScreen(GAMEPLAY);
            }
        });
    }
}
