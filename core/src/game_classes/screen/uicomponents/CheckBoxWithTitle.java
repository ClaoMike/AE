package game_classes.screen.uicomponents;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import game_classes.screen.settings.GameSettings;

public class CheckBoxWithTitle extends ButtonTable {
    private final CustomButton title;
    private final CustomCheckBox checkBox;

    public CheckBoxWithTitle(String title, BitmapFont font, float width, float height, GameSettings settings) {
        super(0, 0);

        this.title = new CustomButton(title, font);
        this.checkBox = new CustomCheckBox(width, height, settings);

        add(this.title);
        add(checkBox);
    }

    public CustomButton getButton() {
        return title;
    }
}