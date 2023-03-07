package refactor.screen.blueprint;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import dev.clao.GameMain;

public class SettingsScreen extends UIScreen {

    private CustomButton title;
    private SliderWithTitle slider;
    private CustomButton exitButton;
    private ButtonTable table;


    public SettingsScreen(GameMain game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();

        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float sliderWidth = screenWidth/4;

        title = new CustomButton(getConstants().GAME_TITLE, getFont().getFont());

        slider = new SliderWithTitle(
                "Maze Size: ",
                getFont().getFont(),
                getConstants().SLIDER_BACKGROUND,
                getConstants().SLIDER_KNOB_BACKGROUND,
                getConstants().SETTINGS_SLIDER_MIN_VALUE,
                getConstants().SETTINGS_SLIDER_MAX_VALUE,
                getConstants().SETTINGS_SLIDER_STEP_VALUE,
                getConstants().SETTINGS_SLIDER_DEFAULT_VALUE,
                sliderWidth);

        exitButton = new CustomButton(getConstants().MAIN_MENU_BUTTON_EXIT, getFont().getFont());
        exitButton.addListener(new ChangeListener() {
            @Override
            public void changed (ChangeEvent event, Actor actor) {
                System.out.println(getConstants().MAIN_MENU_BUTTON_EXIT + " Pressed");
            }
        });

        table = new ButtonTable(screenWidth/2, screenHeight/2);
        table.addCustomButton(title, getConstants().GAME_TITLE_BOTTOM_PADDING, true);
        table.addSliderWithTitle(slider, getConstants().GAME_TITLE_BOTTOM_PADDING, true, sliderWidth);
        table.addCustomButton(exitButton, getConstants().GAME_TITLE_BOTTOM_PADDING, true);

        CheckBox.CheckBoxStyle checkBoxStyle = new CheckBox.CheckBoxStyle();
        checkBoxStyle.font = getFont().getFont();
        CheckBox b = new CheckBox("Test", checkBoxStyle);
        table.getTable().add(b);

        getStage().addActor(table.getTable());
    }

}
