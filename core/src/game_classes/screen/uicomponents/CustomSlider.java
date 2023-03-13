package game_classes.screen.uicomponents;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class CustomSlider {
    private final Slider slider;

    public CustomSlider(String backgroundFilepath, String knobFilepath, float minValue, float maxValue, float stepSize, float initialValue, float width) {
        Slider.SliderStyle sliderStyle = new Slider.SliderStyle();
        sliderStyle.background = generateTextureRegionDrawable(backgroundFilepath);
        sliderStyle.knob =  generateTextureRegionDrawable(knobFilepath);

        slider = new Slider(minValue, maxValue, stepSize, false, sliderStyle);
        slider.setWidth(width);
        slider.setValue(initialValue);
    }

    public Slider getSlider() {
        return slider;
    }

    private TextureRegionDrawable generateTextureRegionDrawable(String filepath) {
        return new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal(filepath))));
    }
}