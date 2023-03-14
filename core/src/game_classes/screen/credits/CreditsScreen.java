package game_classes.screen.credits;

import static game_classes.screen.Screens.MAIN_MENU;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import dev.clao.GameMain;
import game_classes.screen.uicomponents.ButtonTable;
import game_classes.screen.uicomponents.CustomButton;
import game_classes.screen.blueprint.UIScreen;

public class CreditsScreen extends UIScreen {

    public CreditsScreen(GameMain game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();

        CustomButton title = new CustomButton(getConstants().GAME_TITLE, getFont().getFont());
        CustomButton me = new CustomButton(getConstants().PROJECT_DEVELOPER, getFont().getFont());
        CustomButton supervisor = new CustomButton(getConstants().PROJECT_SUPERVISOR, getFont().getFont());
        CustomButton university = new CustomButton(getConstants().UNIVERSITY_NAME, getFont().getFont());

        CustomButton exitButton = new CustomButton(getConstants().MAIN_MENU_BUTTON_EXIT, getFont().getFont());
        exitButton.addListener(new ChangeListener() {
            @Override
            public void changed (ChangeEvent event, Actor actor) {
                System.out.println(getConstants().MAIN_MENU_BUTTON_EXIT + " Pressed");
                game.goToScreen(MAIN_MENU);
            }
        });

        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();

        ButtonTable table = new ButtonTable(screenWidth / 2, screenHeight / 2);

        table.addActor(title, getConstants().GAME_TITLE_BOTTOM_PADDING, true, 0);
        table.addActor(me, getConstants().MAIN_MENU_BUTTON_BOTTOM_PADDING, true, 0);
        table.addActor(supervisor, getConstants().MAIN_MENU_BUTTON_BOTTOM_PADDING, true, 0);
        table.addActor(university, getConstants().GAME_TITLE_BOTTOM_PADDING, true, 0);
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
