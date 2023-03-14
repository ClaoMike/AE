package game_classes.screen.uicomponents;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class CustomSlider extends Slider {
    public CustomSlider(String backgroundFilepath, String knobFilepath, float minValue, float maxValue, float stepSize, float initialValue, float width) {
        super(
                minValue,
                maxValue,
                stepSize,
                false,
                generateStyle(
                        generateTextureRegionDrawable(
                                backgroundFilepath
                        ),
                        generateTextureRegionDrawable(
                                knobFilepath
                        )
                )
        );

        setWidth(width);
        setValue(initialValue);
    }

    private static TextureRegionDrawable generateTextureRegionDrawable(String filepath) {
        return new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal(filepath))));
    }
    private static Slider.SliderStyle generateStyle(Drawable background, Drawable knob) {
        Slider.SliderStyle sliderStyle = new Slider.SliderStyle();
        sliderStyle.background = background;
        sliderStyle.knob = knob;

        return sliderStyle;
    }
}