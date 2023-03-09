package refactor.screens.mainmenu;

import static refactor.screens.Screens.CREDITS;
import static refactor.screens.Screens.GAMEPLAY;
import static refactor.screens.Screens.SETTINGS;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import dev.clao.GameMain;
import refactor.screens.uicomponents.ButtonTable;
import refactor.screens.uicomponents.CustomButton;
import refactor.screens.blueprints.UIScreen;

public class MainMenuScreen extends UIScreen {

    public MainMenuScreen(GameMain game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();

        CustomButton title = new CustomButton(getConstants().GAME_TITLE, getFont().getFont());

        CustomButton playButton = new CustomButton(getConstants().MAIN_MENU_BUTTON_PLAY, getFont().getFont());
        playButton.addListener(new ChangeListener() {
            @Override
            public void changed (ChangeEvent event, Actor actor) {
                game.goToScreen(GAMEPLAY);
            }
        });


        CustomButton creditsButton = new CustomButton(getConstants().MAIN_MENU_BUTTON_CREDITS, getFont().getFont());
        creditsButton.addListener(new ChangeListener() {
            @Override
            public void changed (ChangeEvent event, Actor actor) {
                game.goToScreen(CREDITS);
            }
        });

        CustomButton settingsButton = new CustomButton(getConstants().MAIN_MENU_BUTTON_SETTINGS, getFont().getFont());
        settingsButton.addListener(new ChangeListener() {
            @Override
            public void changed (ChangeEvent event, Actor actor) {
                game.goToScreen(SETTINGS);
            }
        });

        CustomButton exitButton = new CustomButton(getConstants().MAIN_MENU_BUTTON_EXIT, getFont().getFont());
        exitButton.addListener(new ChangeListener() {
            @Override
            public void changed (ChangeEvent event, Actor actor) {
                game.exit();
            }
        });

        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();

        ButtonTable table = new ButtonTable(screenWidth / 2, screenHeight / 2);
        table.addCustomButton(title, getConstants().GAME_TITLE_BOTTOM_PADDING, true);
        table.addCustomButton(playButton, getConstants().MAIN_MENU_BUTTON_BOTTOM_PADDING, true);
        table.addCustomButton(creditsButton, getConstants().MAIN_MENU_BUTTON_BOTTOM_PADDING, true);
        table.addCustomButton(settingsButton, getConstants().MAIN_MENU_BUTTON_BOTTOM_PADDING, true);
        table.addCustomButton(exitButton, getConstants().MAIN_MENU_BUTTON_BOTTOM_PADDING, true);

        getStage().addActor(table.getTable());
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();

        getBatch().begin();
        getStage().draw();
        getFont().drawText(getConstants().GAME_VERSION, screenWidth/10, screenHeight/6);
        getBatch().end();

        mainCamera.update();
    }

}
