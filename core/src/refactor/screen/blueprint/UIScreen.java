package refactor.screen.blueprint;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import dev.clao.GameMain;

public class UIScreen extends SimpleScreen {
    Stage stage;
    CustomButton button1;
    CustomButton button2;
    public UIScreen(GameMain game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();

        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        button1 = new CustomButton("Play", getFont().getFont());
        button1.addListener(new ChangeListener() {
            @Override
            public void changed (ChangeEvent event, Actor actor) {
                System.out.println("Play Pressed");
            }
        });

        button2 = new CustomButton("Exit", getFont().getFont());
        button2.addListener(new ChangeListener() {
            @Override
            public void changed (ChangeEvent event, Actor actor) {
                System.out.println("Exit Pressed");
            }
        });

        Table table = new Table();
        table.add(button1.getButton()).padBottom(50);
        table.row();

        table.add(button2.getButton());

        table.setPosition(400, 400);

        stage.addActor(table);
    }


    @Override
    public void render(float delta) {
        super.render(delta);

        getBatch().begin();

        getFont().drawText("Hello, world!", 100, 100);
//        getFont().drawText("Joking!", 400, 400);
        stage.draw();

        getBatch().end();
    }


}
