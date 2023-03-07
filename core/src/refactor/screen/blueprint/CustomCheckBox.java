package refactor.screen.blueprint;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class CustomCheckBox extends Actor {
    private boolean isChecked = false;

    public CustomCheckBox(float width, float height) {
        setSize(width, height);
        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                isChecked = !isChecked;
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