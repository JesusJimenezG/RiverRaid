package map;

import display.Camera;
import entity.Position;
import entity.Size;
import game.Game;
import gfx.SpriteLibrary;
import utils.Constants;

import java.util.Arrays;

public class GameMap {
    private static final int SAFETY_SPACE = 2;

    private Tile[][] tiles;

    public GameMap(Size size, SpriteLibrary spriteLibrary, String tileName) {
        tiles = new Tile[size.getWidth()][size.getHeight()];
        initializeTiles(spriteLibrary, tileName);
    }

    private void initializeTiles(SpriteLibrary spriteLibrary, String tileName) {
        for (Tile[] row: tiles){
            Arrays.fill(row, new Tile(spriteLibrary, tileName));
        }
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public void setTiles(Tile[][] tiles) {
        this.tiles = tiles;
    }

    public Position getRandomPosition() {
        double x = Math.random() * Constants.SCREEN_SIZE.getWidth();
        double y = Math.random() * Constants.SCREEN_SIZE.getHeight() / 2;

        return new Position(x, y);
    }

    public Position getViewableStartingGridPosition(Camera camera) {
        return new Position(
                Math.max(0, camera.getPosition().getX() / Constants.TILE_SIZE - SAFETY_SPACE),
                Math.max(0, camera.getPosition().getY() / Constants.TILE_SIZE - SAFETY_SPACE)
        );
    }

    public Position getViewableEndingGridPosition(Camera camera) {
        return new Position(
                Math.min(tiles.length, camera.getPosition().getX() / Constants.TILE_SIZE + camera.getSize().getWidth() / Constants.TILE_SIZE + SAFETY_SPACE),
                Math.min(tiles[0].length, camera.getPosition().getY() / Constants.TILE_SIZE + camera.getSize().getHeight() / Constants.TILE_SIZE + SAFETY_SPACE)
        );
    }
}
