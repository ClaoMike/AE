package refactor.screens.uicomponents;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import refactor.GameSettings;

public class SliderWithTitle extends CustomSlider {
    private final CustomButton title;
    private final String text;
    private GameSettings settings;

    public SliderWithTitle(String title, BitmapFont font, String backgroundFilepath, String knobFilepath, float minValue, float maxValue, float stepSize, float width, final GameSettings settings) {
        super(backgroundFilepath, knobFilepath, minValue, maxValue, stepSize, settings.getMazeSize(), width);
        this.text = title;
        this.title = new CustomButton(text + (int)settings.getMazeSize(), font);
        this.settings = settings;

        getSlider().addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                int newValue = (int) getSlider().getValue();
                updateText(newValue);
                settings.setMazeSize(newValue);
            }
        });
    }

    private void updateText(float newValue) {
        title.updateText(text + (int)newValue);
    }
    public CustomButton getTitle() {
        return title;
    }
}