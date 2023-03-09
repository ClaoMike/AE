package objects.gameplay.player;

import refactor.objects.player.Directions;

public interface PlayerActions {

    void go(Directions direction);
    void stopMoving();
}
