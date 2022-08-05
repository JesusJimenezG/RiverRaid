package entity;

import controller.Controller;
import core.Direction;
import core.Movement;
import game.state.State;
import gfx.AnimationManager;
import gfx.SpriteLibrary;

import java.awt.*;

public abstract class MovingEntity extends GameObject {

    protected Controller controller;
    protected Movement movement;
    protected AnimationManager animationManager;
    protected Direction direction;

    public MovingEntity(Controller controller, SpriteLibrary spriteLibrary, Position position, Size size) {
        super(position, size);
        this.controller = controller;
        movement = new Movement(2);
        direction = Direction.Up;
        animationManager = new AnimationManager();
    }
    @Override
    public void update(State state){
        movement.update(controller);
        position.apply(movement);
        manageDirection();
        animationManager.update(direction);
    }

    private void manageDirection() {
        if (movement.isMoving()){
            direction = Direction.fromMovement(movement);
//            System.out.println(direction);
        }
    }

    @Override
    public Image getSprite(){
        return animationManager.getSprite();
    }

    public Controller getController() {
        return controller;
    }
}
