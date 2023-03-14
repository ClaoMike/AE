package game_classes.screen.gameplay;

import com.badlogic.gdx.graphics.g2d.BitmapFont;

import game_classes.screen.uicomponents.ButtonTable;
import game_classes.screen.uicomponents.CustomButton;

public class GameMenu extends ButtonTable {
    public GameMenu(String button1Text, String button2Text, BitmapFont font) {
        super(0, 0);

        CustomButton b1 = new CustomButton(button1Text, font);
        CustomButton b2 = new CustomButton(button2Text, font);

        addActor(b1, 50, true, 0);
        addActor(b2, 50, true, 0);
    }
}
