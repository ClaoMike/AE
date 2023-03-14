package game_classes.screen.uicomponents;

import com.badlogic.gdx.graphics.g2d.BitmapFont;

import game_classes.screen.settings.GameSettings;

public class CheckBoxWithTitle extends ButtonTable {

    public CheckBoxWithTitle(String title, BitmapFont font, float width, float height, GameSettings settings) {
        super(0, 0);

        CustomButton title1 = new CustomButton(title, font);
        CustomCheckBox checkBox = new CustomCheckBox(width, height, settings);

        add(title1);
        add(checkBox);
    }
}