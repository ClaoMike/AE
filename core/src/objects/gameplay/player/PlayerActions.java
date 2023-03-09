package objects.gameplay.player;

import refactor.objects.Directions;

public interface PlayerActions {

    void go(Directions direction);
    void stopMoving();
}
