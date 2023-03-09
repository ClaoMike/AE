package refactor.objects;

import com.badlogic.gdx.math.Vector2;

import helpers.GameInfo;

public enum Directions {
        UP(new Vector2(0, 100)),
        DOWN(new Vector2(0, -100)),
        LEFT(new Vector2(-100, GameInfo.NULL_FORCE)),
        RIGHT(new Vector2(100, GameInfo.NULL_FORCE));

        private Vector2 vector;

        Directions(Vector2 vector) {
            this.vector = vector;
        }

        public Vector2 getVector() {
            return vector;
        }

}
