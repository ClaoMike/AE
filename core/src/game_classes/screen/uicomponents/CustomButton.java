package game_classes.screen.uicomponents;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class CustomButton extends TextButton {

    public CustomButton(String text, BitmapFont font) {
        super(text, generateNewStyle(font));
    }

    private static TextButton.TextButtonStyle generateNewStyle(BitmapFont font) {
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = font;
        textButtonStyle.fontColor = font.getColor();

        return textButtonStyle;
    }
}
