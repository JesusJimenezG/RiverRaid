package map;

import gfx.SpriteLibrary;

import java.awt.*;

public class Tile {
    private Image sprite;

    public Tile(SpriteLibrary spriteLibrary, String name) {
        this.sprite = spriteLibrary.getTile(name);
    }

    public Image getSprite(){
        return sprite;
    }
}
