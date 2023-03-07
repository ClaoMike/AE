package refactor.screen.blueprint;

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

    public void addCustomButton(CustomButton cb, float bottomPadding, boolean newRow) {
        table.add(cb.getButton()).padBottom(bottomPadding);
        if(newRow) {
            table.row();
        }
    }

    public void addCustomSlider(CustomSlider cs, float bottomPadding, boolean newRow, float width) {
        table.add(cs.getSlider()).padBottom(bottomPadding).width(width);
        if(newRow) {
            table.row();
        }
    }

    public void addSliderWithTitle(SliderWithTitle cs, float bottomPadding, boolean newRow, float width) {
        addCustomButton(cs.getTitle(), 10, true);
        table.add(cs.getSlider()).padBottom(bottomPadding).width(width);
        if(newRow) {
            table.row();
        }
    }

    public void addCheckBoxWithTitle(CheckBoxWithTitle cwt, float bottomPadding, boolean newRow) {
        addCustomButton(cwt.getButton(), bottomPadding, false);
        table.add(cwt).padBottom(bottomPadding).padLeft(-100);
        if(newRow) {
            table.row();
        }
    }

    public Table getTable() {
        return table;
    }
}
