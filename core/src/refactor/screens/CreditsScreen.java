package refactor.screens;

import static refactor.screens.Screens.MAIN_MENU;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import dev.clao.GameMain;
import refactor.screens.uicomponents.ButtonTable;
import refactor.screens.uicomponents.CustomButton;
import refactor.screens.blueprints.UIScreen;

public class CreditsScreen extends UIScreen {
    private CustomButton title;
    private CustomButton me;
    private CustomButton supervisor;
    private CustomButton university;
    private CustomButton exitButton;
    private ButtonTable table;

    public CreditsScreen(GameMain game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();

        title = new CustomButton(getConstants().GAME_TITLE, getFont().getFont());
        me = new CustomButton(getConstants().PROJECT_DEVELOPER, getFont().getFont());
        supervisor = new CustomButton(getConstants().PROJECT_SUPERVISIOR, getFont().getFont());
        university = new CustomButton(getConstants().UNIVERSITY_NAME, getFont().getFont());

        exitButton = new CustomButton(getConstants().MAIN_MENU_BUTTON_EXIT, getFont().getFont());
        exitButton.addListener(new ChangeListener() {
            @Override
            public void changed (ChangeEvent event, Actor actor) {
                System.out.println(getConstants().MAIN_MENU_BUTTON_EXIT + " Pressed");
                game.goToScreen(MAIN_MENU);
            }
        });

        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();

        table = new ButtonTable(screenWidth/2, screenHeight/2);
        table.addCustomButton(title, getConstants().GAME_TITLE_BOTTOM_PADDING, true);
        table.addCustomButton(me, getConstants().MAIN_MENU_BUTTON_BOTTOM_PADDING, true);
        table.addCustomButton(supervisor, getConstants().MAIN_MENU_BUTTON_BOTTOM_PADDING, true);
        table.addCustomButton(university, getConstants().GAME_TITLE_BOTTOM_PADDING, true);
        table.addCustomButton(exitButton, getConstants().GAME_TITLE_BOTTOM_PADDING, true);

        getStage().addActor(table.getTable());
    }
}
