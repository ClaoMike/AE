package game_classes.screen.uicomponents;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class TextureRegionDrawableGenerator {
    public static TextureRegionDrawable generate(String filepath) {
        return new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal(filepath))));
    }
}