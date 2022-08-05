package map;

import entity.Size;
import gfx.SpriteLibrary;
import utils.Constants;

import java.util.Arrays;

public class River {
    private Tile[][] tiles;

    public River(Size size, SpriteLibrary spriteLibrary) {
        tiles = new Tile[size.getWidth()][size.getHeight()];
        initializeTiles(spriteLibrary);
    }

    private void initializeTiles(SpriteLibrary spriteLibrary) {
        for (Tile[] row: tiles){
            Arrays.fill(row, new Tile(spriteLibrary, Constants.BACKGROUND_TILE));
        }
    }

    public Tile[][] getTiles() {
        return tiles;
    }
}
