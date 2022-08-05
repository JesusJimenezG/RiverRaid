package entity;

import controller.Controller;
import gfx.AnimationManager;
import gfx.SpriteLibrary;

public class Player extends MovingEntity{

    public Player(Controller controller, SpriteLibrary spriteLibrary, Position position, Size size) {
        super(controller, spriteLibrary, position, size);
        animationManager = new AnimationManager(spriteLibrary.getUnit("player"), "jet");
    }

//    @Override
//    public void update() {
//        super.update();
//    }
}
