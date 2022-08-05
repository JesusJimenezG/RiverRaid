package entity;

import game.state.State;
import utils.Constants;

import java.awt.*;

public abstract class GameObject {
    protected Position position;
    protected Size size;

    public GameObject() {
        position = new Position(Constants.SCREEN_SIZE.width / 2, Constants.SCREEN_SIZE.height / 2);
        size = new Size(Constants.SCREEN_SIZE.width, Constants.SCREEN_SIZE.height);
    }

    public GameObject(Position position, Size size) {
        this.position = position;
        this.size = size;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public abstract void update(State state);
    public abstract Image getSprite();
}
