package refactor.screens.uicomponents;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

public class SliderWithTitle extends CustomSlider {
    private final CustomButton title;
    private final String text;

    public SliderWithTitle(String title, BitmapFont font, String backgroundFilepath, String knobFilepath, float minValue, float maxValue, float stepSize, float initialValue, float width) {
        super(backgroundFilepath, knobFilepath, minValue, maxValue, stepSize, initialValue, width);
        this.text = title;
        this.title = new CustomButton(text + (int)initialValue, font);

        getSlider().addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                updateText(getSlider().getValue());
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