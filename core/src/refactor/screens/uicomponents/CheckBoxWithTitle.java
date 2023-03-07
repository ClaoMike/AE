package refactor.screens.uicomponents;

import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class CheckBoxWithTitle extends CustomCheckBox {
    private CustomButton title;

    public CheckBoxWithTitle(String title, BitmapFont font, float width, float height) {
        super(width, height);

        this.title = new CustomButton(title, font);
    }

    public CustomButton getButton() {
        return title;
    }
}