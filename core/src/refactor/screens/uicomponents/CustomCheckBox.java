package refactor.screens.uicomponents;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import refactor.GameSettings;

public class CustomCheckBox extends Actor {
    private boolean isChecked = false;
    private GameSettings settings;

    public CustomCheckBox(float width, float height, final GameSettings settings) {
        this.settings = settings;
        isChecked = settings.getDebugMode();

        setSize(width, height);
        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                isChecked = !isChecked;
                settings.setDebugMode(isChecked);
            }
        });
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        batch.end();
        ShapeRenderer shapeRenderer = generateShapeRenderer(batch, Color.YELLOW, Color.YELLOW, Color.RED);
        batch.begin();
    }

    private ShapeRenderer generateShapeRenderer(Batch batch, Color checkedColor, Color uncheckedColor, Color checkColor) {
        ShapeRenderer shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(batch.getProjectionMatrix());
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        shapeRenderer.setColor(isChecked ? checkedColor : uncheckedColor);
        shapeRenderer.rect(getX(), getY(), getWidth(), getHeight());

        shapeRenderer.setColor(checkColor);
        if (isChecked) {
            shapeRenderer.line(getX(), getY(), getX() + getWidth(), getY() + getHeight());
            shapeRenderer.line(getX() + getWidth(), getY(), getX(), getY() + getHeight());
        }
        shapeRenderer.end();

        return shapeRenderer;
    }

    public boolean isChecked() {
        return isChecked;
    }
}