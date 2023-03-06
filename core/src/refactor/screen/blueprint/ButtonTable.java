package refactor.screen.blueprint;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class ButtonTable {
    private final Table table;

    public ButtonTable() {
        table = new Table();
    }

    public ButtonTable(float x, float y) {
        table = new Table();
        setPosition(x, y);
    }

    public void setPosition(float x, float y) {
        table.setPosition(x, y);
    }

    public void addActor(Actor actor) {
        table.add(actor).padBottom(50);
        table.row();
    }

    public void addActor(Actor actor, int bottomPadding) {
        table.add(actor).padBottom(bottomPadding);
        table.row();
    }

    public Table getTable() {
        return table;
    }
}
