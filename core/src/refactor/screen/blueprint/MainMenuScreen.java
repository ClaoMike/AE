package refactor.screen.blueprint;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import dev.clao.GameMain;

public class MainMenuScreen extends UIScreen {
    private CustomButton title;
    private CustomButton playButton;
    private CustomButton creditsButton;
    private CustomButton settingsButton;
    private CustomButton exitButton;

    private ButtonTable table;

    public MainMenuScreen(GameMain game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();

        title = new CustomButton(getConstants().GAME_TITLE, getFont().getFont());

        playButton = new CustomButton(getConstants().MAIN_MENU_BUTTON_PLAY, getFont().getFont());
        playButton.addListener(new ChangeListener() {
            @Override
            public void changed (ChangeEvent event, Actor actor) {
                System.out.println(getConstants().MAIN_MENU_BUTTON_PLAY + " Pressed");
            }
        });


        creditsButton = new CustomButton(getConstants().MAIN_MENU_BUTTON_CREDITS, getFont().getFont());
        creditsButton.addListener(new ChangeListener() {
            @Override
            public void changed (ChangeEvent event, Actor actor) {
                System.out.println(getConstants().MAIN_MENU_BUTTON_CREDITS + " Pressed");
            }
        });

        settingsButton = new CustomButton(getConstants().MAIN_MENU_BUTTON_SETTINGS, getFont().getFont());
        settingsButton.addListener(new ChangeListener() {
            @Override
            public void changed (ChangeEvent event, Actor actor) {
                System.out.println(getConstants().MAIN_MENU_BUTTON_SETTINGS + " Pressed");
            }
        });

        exitButton = new CustomButton(getConstants().MAIN_MENU_BUTTON_EXIT, getFont().getFont());
        exitButton.addListener(new ChangeListener() {
            @Override
            public void changed (ChangeEvent event, Actor actor) {
                System.out.println(getConstants().MAIN_MENU_BUTTON_EXIT + " Pressed");
            }
        });

        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();

        table = new ButtonTable(screenWidth/2, screenHeight/2);
        table.addActor(title.getButton(), getConstants().GAME_TITLE_BOTTOM_PADDING);
        table.addActor(playButton.getButton());
        table.addActor(creditsButton.getButton());
        table.addActor(settingsButton.getButton());
        table.addActor(exitButton.getButton());

        getStage().addActor(table.getTable());
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();

        getBatch().begin();
        getFont().drawText(getConstants().GAME_VERSION, screenWidth/10, screenHeight/5);
        getBatch().end();
    }

}
