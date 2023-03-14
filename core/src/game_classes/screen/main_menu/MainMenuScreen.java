package game_classes.screen.main_menu;

import static game_classes.screen.Screens.CREDITS;
import static game_classes.screen.Screens.GAMEPLAY;
import static game_classes.screen.Screens.SETTINGS;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import dev.clao.GameMain;
import game_classes.screen.uicomponents.ButtonTable;
import game_classes.screen.uicomponents.CustomButton;
import game_classes.screen.blueprint.UIScreen;

public class MainMenuScreen extends UIScreen {

    public MainMenuScreen(GameMain game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();

        CustomButton title = new CustomButton(getConstants().GAME_TITLE, font);

        CustomButton playButton = new CustomButton(getConstants().MAIN_MENU_BUTTON_PLAY, font);
        playButton.addListener(new ChangeListener() {
            @Override
            public void changed (ChangeEvent event, Actor actor) {
                game.goToScreen(GAMEPLAY);
            }
        });


        CustomButton creditsButton = new CustomButton(getConstants().MAIN_MENU_BUTTON_CREDITS, font);
        creditsButton.addListener(new ChangeListener() {
            @Override
            public void changed (ChangeEvent event, Actor actor) {
                game.goToScreen(CREDITS);
            }
        });

        CustomButton settingsButton = new CustomButton(getConstants().MAIN_MENU_BUTTON_SETTINGS, font);
        settingsButton.addListener(new ChangeListener() {
            @Override
            public void changed (ChangeEvent event, Actor actor) {
                game.goToScreen(SETTINGS);
            }
        });

        CustomButton exitButton = new CustomButton(getConstants().MAIN_MENU_BUTTON_EXIT, font);
        exitButton.addListener(new ChangeListener() {
            @Override
            public void changed (ChangeEvent event, Actor actor) {
                game.exit();
            }
        });

        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();

        ButtonTable table = new ButtonTable(screenWidth / 2, screenHeight / 2);
        table.addActor(title, getConstants().GAME_TITLE_BOTTOM_PADDING, true, 0);
        table.addActor(playButton, getConstants().MAIN_MENU_BUTTON_BOTTOM_PADDING, true, 0);
        table.addActor(creditsButton, getConstants().MAIN_MENU_BUTTON_BOTTOM_PADDING, true, 0);
        table.addActor(settingsButton, getConstants().MAIN_MENU_BUTTON_BOTTOM_PADDING, true, 0);
        table.addActor(exitButton, getConstants().MAIN_MENU_BUTTON_BOTTOM_PADDING, true, 0);

        getStage().addActor(table);
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();

        getBatch().begin();
        getStage().draw();
        font.draw(getBatch(), getConstants().GAME_VERSION, screenWidth/10, screenHeight/6);
        getBatch().end();

        mainCamera.update();
    }

}
