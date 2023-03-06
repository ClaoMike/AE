package refactor.screen.blueprint;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class CustomButton {

    TextButton button;

    public CustomButton(String text, BitmapFont font) {
        TextButton.TextButtonStyle textButtonStyle = generateNewStyle(font);
        button = new TextButton(text, textButtonStyle);
    }

    public void addListener(EventListener listener) {
        button.addListener(listener);
    }

    public TextButton getButton() {
        return button;
    }

    private TextButton.TextButtonStyle generateNewStyle(BitmapFont font) {
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = font;
        textButtonStyle.fontColor = font.getColor();

        return textButtonStyle;
    }
}
