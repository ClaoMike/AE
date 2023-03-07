package refactor.screens.uicomponents;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class CustomFont {
    private BitmapFont font;
    private final FreeTypeFontGenerator generator;
    private final FreeTypeFontGenerator.FreeTypeFontParameter parameter;
    private final SpriteBatch batch;

    public CustomFont(String filepath, int size, Color colour, SpriteBatch batch) {
        this.batch = batch;

        generator = new FreeTypeFontGenerator(Gdx.files.internal(filepath));
        parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();

        setSize(size);
        setColour(colour);
    }

    public void setSize(int size) {
        parameter.size = size;
        font = generator.generateFont(parameter);
    }

    public BitmapFont getFont() {
        return font;
    }

    public void dispose() {
        generator.dispose();
    }

    public void setColour(Color c) {
        font.setColor(c);
    }

    public void drawText(String text, float x, float y) {
        font.draw(batch, text, x, y);
    }

}