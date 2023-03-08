package refactor.screens;

import static refactor.screens.Screens.MAIN_MENU;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import dev.clao.GameMain;
import refactor.screens.uicomponents.ButtonTable;
import refactor.screens.uicomponents.CheckBoxWithTitle;
import refactor.screens.uicomponents.CustomButton;
import refactor.screens.uicomponents.SliderWithTitle;
import refactor.screens.blueprints.UIScreen;

public class SettingsScreen extends UIScreen {
    public SettingsScreen(GameMain game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();

        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float sliderWidth = screenWidth/4;

        CustomButton title = new CustomButton(getConstants().GAME_TITLE, getFont().getFont());

        SliderWithTitle slider = new SliderWithTitle(
                getConstants().SLIDER_MAZE_SIZE_TITLE,
                getFont().getFont(),
                getConstants().SLIDER_BACKGROUND,
                getConstants().SLIDER_KNOB_BACKGROUND,
                getConstants().SETTINGS_SLIDER_MIN_VALUE,
                getConstants().SETTINGS_SLIDER_MAX_VALUE,
                getConstants().SETTINGS_SLIDER_STEP_VALUE,
                sliderWidth,
                game.settings
        );

        CheckBoxWithTitle checkBox = new CheckBoxWithTitle(
                getConstants().DEBUG_MODE_CHECKBOX_TITLE,
                getFont().getFont(),
                screenWidth / 50,
                screenWidth / 50,
                game.settings
        );

        CustomButton exitButton = new CustomButton(getConstants().MAIN_MENU_BUTTON_EXIT, getFont().getFont());
        exitButton.addListener(new ChangeListener() {
            @Override
            public void changed (ChangeEvent event, Actor actor) {
                game.goToScreen(MAIN_MENU);
            }
        });

        ButtonTable table = new ButtonTable(screenWidth / 2, screenHeight / 2);
        table.addCustomButton(title, getConstants().GAME_TITLE_BOTTOM_PADDING, true);
        table.addSliderWithTitle(slider, getConstants().MAIN_MENU_BUTTON_BOTTOM_PADDING, true, sliderWidth);
        table.addCheckBoxWithTitle(checkBox, getConstants().GAME_TITLE_BOTTOM_PADDING, true);
        table.addCustomButton(exitButton, getConstants().GAME_TITLE_BOTTOM_PADDING, true);

        getStage().addActor(table.getTable());
    }

}