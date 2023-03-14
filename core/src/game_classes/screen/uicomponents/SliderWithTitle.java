package game_classes.screen.uicomponents;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import game_classes.screen.settings.GameSettings;

public class SliderWithTitle extends ButtonTable {
    private final String text;
    private final CustomButton title;
    private final CustomSlider slider;


    public SliderWithTitle(String text, BitmapFont font, String backgroundFilepath, String knobFilepath, float minValue, float maxValue, float stepSize, float width, final GameSettings settings) {
        super(0, 0);
        this.text = text;
        this.title = new CustomButton(textFormatter(settings.getMazeSize()), font);
        this.slider = new CustomSlider(backgroundFilepath, knobFilepath, minValue, maxValue, stepSize, settings.getMazeSize(), width);

        addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                int newValue = (int) slider.getValue();
                updateText(newValue);
                settings.setMazeSize(newValue);
            }
        });

        addActor(title, 0, true, 0);
        addActor(slider, 0, false, 700);
    }

    private void updateText(float newValue) {
        title.setText(textFormatter(newValue));
    }

    private String textFormatter(float value) {
        int newValue = (int) value;

        return text + newValue + " x " + newValue;
    }
}