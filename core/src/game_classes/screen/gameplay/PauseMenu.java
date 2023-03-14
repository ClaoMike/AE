package game_classes.screen.gameplay;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import dev.clao.GameMain;

public class PauseMenu extends  GameMenu {

    public PauseMenu(GameMain game, BitmapFont font, final GameplayScreen screen) {
        super(game, "Resume", font);

        firstButton.addListener(new ChangeListener() {
            @Override
            public void changed (ChangeEvent event, Actor actor) {
                screen.dismissPauseMenu();
            }
        });
    }
}
