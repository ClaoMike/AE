package game_classes.screen.uicomponents;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class ButtonTable extends Table {

    public ButtonTable(float x, float y) {
        super();
        setPosition(x, y);
    }

    public void addActor(Actor actor, float bottomPadding, boolean newRow, float width) {
        if(width > 0){
            add(actor).padBottom(bottomPadding).width(width);
        } else {
            add(actor).padBottom(bottomPadding);
        }

        if(newRow) {
            row();
        }
    }
}
