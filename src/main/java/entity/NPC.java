package entity;

import ai.AIManager;
import controller.Controller;
import game.state.State;
import gfx.AnimationManager;
import gfx.SpriteLibrary;
import gfx.SpriteSet;

import java.awt.*;

public class NPC extends MovingEntity {
    private AIManager aiManager;
    private SpriteSet spriteSet;

    public NPC(Controller controller, SpriteLibrary spriteLibrary, Position position, Size size) {
        super(controller, spriteLibrary, position, size);
        spriteSet = spriteLibrary.getUnit("enemies");
        animationManager = new AnimationManager(spriteLibrary.getUnit("enemies"), "helicopter_right");
        aiManager = new AIManager();
    }

    @Override
    public void update(State state) {
        super.update(state);
        aiManager.update(state, this);
    }

//    @Override
//    public Image getSprite(){
//        return spriteSet.get("helicopter");
//    }
}
