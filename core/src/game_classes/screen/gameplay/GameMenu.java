package game_classes.screen.gameplay;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import game_classes.Constants;
import game_classes.screen.uicomponents.ButtonTable;
import game_classes.screen.uicomponents.CustomButton;

public class GameMenu extends ButtonTable {
    private CustomButton firstButton;
    private CustomButton secondButton;
    public GameMenu(String button1Text, String button2Text, BitmapFont font) {
        super(0, 0);

        firstButton = new CustomButton(button1Text, font);
        secondButton = new CustomButton(button2Text, font);

        TextureRegionDrawable drawable = generateTextureRegionDrawable(Constants.GAME_MENU_BACKGROUND_IMAGE_FILEPATH);
        Vector2 drawableSize = getImageSize(Constants.GAME_MENU_BACKGROUND_IMAGE_FILEPATH);
        setBackground(drawable);

        addActor(firstButton, 50, true, 0);
        addActor(secondButton, 50, true, 0);

        setPosition((Gdx.graphics.getWidth() - drawableSize.x)/2f, (Gdx.graphics.getHeight() - drawableSize.y)/2);
        pack();
    }

    private static TextureRegionDrawable generateTextureRegionDrawable(String filepath) {
        return new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal(filepath))));
    }

    private Vector2 getImageSize(String filepath) {
        Texture t = new Texture(filepath);
        Vector2 size = new Vector2(t.getWidth(), t.getHeight());
        t.dispose();

        return size;
    }

}
