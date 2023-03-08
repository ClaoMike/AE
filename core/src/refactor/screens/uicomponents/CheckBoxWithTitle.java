package refactor.screens.uicomponents;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import refactor.GameSettings;

public class CheckBoxWithTitle extends CustomCheckBox {
    private final CustomButton title;

    public CheckBoxWithTitle(String title, BitmapFont font, float width, float height, GameSettings settings) {
        super(width, height, settings);

        this.title = new CustomButton(title, font);
    }

    public CustomButton getButton() {
        return title;
    }
}