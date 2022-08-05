package display;

import core.Movement;
import entity.GameObject;
import game.state.State;

import java.awt.*;

public class Scroller extends GameObject {
    private Movement movement;

    public Scroller() {
        super();
        movement = new Movement(2);
    }

    @Override
    public void update(State state) {
        movement.scroll();
        position.apply(movement);
    }

    @Override
    public Image getSprite() {
        return null;
    }
}
