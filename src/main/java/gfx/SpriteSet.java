package gfx;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class SpriteSet {
    private Map<String, Image> animationSheets;

    public SpriteSet(){
        this.animationSheets = new HashMap<>();
    }

    public void addSheet(String name, Image animationSheet){
        this.animationSheets.put(name, animationSheet);
    }

    public Image get(String name){
        return animationSheets.get(name);
    }
}
