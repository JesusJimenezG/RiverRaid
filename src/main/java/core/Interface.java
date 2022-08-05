package core;

import entity.GameObject;
import entity.Position;
import entity.Size;
import game.state.State;
import gfx.SpriteLibrary;
import map.Tile;
import utils.Constants;

import java.awt.*;
import java.util.Arrays;

public class Interface extends GameObject {

    private Tile[][] tiles;

    public Interface(Position position, Size size, SpriteLibrary spriteLibrary) {
        super(position, size);
        tiles = new Tile[size.getWidth()][size.getHeight()];

        initializeTiles(spriteLibrary);
    }

    private void initializeTiles(SpriteLibrary spriteLibrary) {
        for (Tile[] row: tiles){
            Arrays.fill(row, new Tile(spriteLibrary, Constants.INTERFACE_TILE));
        }
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public void setTiles(Tile[][] tiles) {
        this.tiles = tiles;
    }

    @Override
    public void update(State state) {}

    @Override
    public Image getSprite() {
        return null;
    }
}
