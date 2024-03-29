package game_classes.screen.settings;

import static game_classes.screen.Screens.MAIN_MENU;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import dev.clao.GameMain;
import game_classes.screen.uicomponents.ButtonTable;
import game_classes.screen.uicomponents.CheckBoxWithTitle;
import game_classes.screen.uicomponents.CustomButton;
import game_classes.screen.uicomponents.SliderWithTitle;
import game_classes.screen.blueprint.UIScreen;

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

        CustomButton title = new CustomButton(getConstants().GAME_TITLE, font);

        SliderWithTitle slider = new SliderWithTitle(
                getConstants().SLIDER_MAZE_SIZE_TITLE,
                font,
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
                font,
                screenWidth / 50,
                screenWidth / 50,
                game.settings
        );

        CustomButton exitButton = new CustomButton(getConstants().MAIN_MENU_BUTTON_EXIT, font);
        exitButton.addListener(new ChangeListener() {
            @Override
            public void changed (ChangeEvent event, Actor actor) {
                game.goToScreen(MAIN_MENU);
            }
        });

        ButtonTable table = new ButtonTable(screenWidth / 2, screenHeight / 2);
        table.addActor(title, getConstants().GAME_TITLE_BOTTOM_PADDING, true, 0);
        table.addActor(slider, getConstants().MAIN_MENU_BUTTON_BOTTOM_PADDING, true, sliderWidth);
        table.addActor(checkBox, getConstants().GAME_TITLE_BOTTOM_PADDING, true, 0);
        table.addActor(exitButton, getConstants().GAME_TITLE_BOTTOM_PADDING, true, 0);

        getStage().addActor(table);
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        getBatch().begin();
        getStage().draw();
        getBatch().end();

        mainCamera.update();
    }

}