package controller;

import java.awt.event.KeyEvent;

public class EntityController implements Controller {
    private Input input;

    public EntityController(Input input) {
        this.input = input;
    }

    @Override
    public boolean isRequestingUp() {
        return input.isPressed(KeyEvent.VK_UP);
    }

    @Override
    public boolean isRequestingDown() {
        return input.isPressed(KeyEvent.VK_DOWN);
    }

    @Override
    public boolean isRequestingLeft() {
        return input.isPressed(KeyEvent.VK_LEFT);
    }

    @Override
    public boolean isRequestingRight() {
        return input.isPressed(KeyEvent.VK_RIGHT);
    }
}
