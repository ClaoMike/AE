package game_classes.screen.gameplay;

import static game_classes.screen.Screens.MAIN_MENU;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import dev.clao.GameMain;
import game_classes.Constants;
import game_classes.screen.uicomponents.ButtonTable;
import game_classes.screen.uicomponents.CustomButton;
import game_classes.screen.uicomponents.TextureRegionDrawableGenerator;

public class GameMenu extends ButtonTable {
    protected final CustomButton firstButton;
    protected final CustomButton secondButton;

    public GameMenu(final GameMain game, String button1Text, BitmapFont font) {
        super(0, 0);

        firstButton = new CustomButton(button1Text, font);
        secondButton = new CustomButton(Constants.MAIN_MENU_STRING, font);

        secondButton.addListener(new ChangeListener() {
            @Override
            public void changed (ChangeEvent event, Actor actor) {
                game.goToScreen(MAIN_MENU);
            }
        });

        TextureRegionDrawable drawable = TextureRegionDrawableGenerator.generate(Constants.GAME_MENU_BACKGROUND_IMAGE_FILEPATH);
        Vector2 drawableSize = getImageSize();
        setBackground(drawable);

        addActor(firstButton, 50, true, 0);
        addActor(secondButton, 50, true, 0);

        setPosition((Gdx.graphics.getWidth() - drawableSize.x)/2f, (Gdx.graphics.getHeight() - drawableSize.y)/2);
        pack();
    }

    private Vector2 getImageSize() {
        Texture t = new Texture(Constants.GAME_MENU_BACKGROUND_IMAGE_FILEPATH);
        Vector2 size = new Vector2(t.getWidth(), t.getHeight());
        t.dispose();

        return size;
    }

}
