package gfx;

import core.Direction;
import utils.Constants;

import java.awt.*;
import java.awt.image.BufferedImage;

public class AnimationManager {
    private SpriteSet spriteSet;
    private BufferedImage currentAnimationSheet;
    private int currentFrameTime, updatesPerFrame, frameIndex, directionIndex;

    public AnimationManager() { }

    public AnimationManager(SpriteSet spriteSet, String animationName) {
        this.spriteSet = spriteSet;
        updatesPerFrame = 20;
        frameIndex = 0;
        currentFrameTime = 0;
        directionIndex = 0;
        playAnimation(animationName);
    }

    public Image getSprite() {
//        directionIndex = directionIndex == Direction.Right.getAnimationRow()
//                ? directionIndex * Constants.SPRITE_SIZE + 2
//                : directionIndex * Constants.SPRITE_SIZE;
        return currentAnimationSheet.getSubimage(
                directionIndex * Constants.SPRITE_WIDTH,
                0,
                Constants.SPRITE_WIDTH,
                Constants.SPRITE_HEIGHT
        );
    }

    public void update(Direction direction) {
        currentFrameTime++;
        directionIndex = direction.getAnimationRow();

        if (currentFrameTime >= updatesPerFrame) {
            currentFrameTime = 0;
            frameIndex++;

            if (frameIndex >= currentAnimationSheet.getWidth() / Constants.SPRITE_WIDTH - 1) {
                frameIndex = 0;
            }
        }
    }

    public void playAnimation(String name) {
        this.currentAnimationSheet = (BufferedImage) spriteSet.get(name);
    }
}

