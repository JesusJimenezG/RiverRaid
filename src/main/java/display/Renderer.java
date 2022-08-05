package display;

import core.Interface;
import entity.Position;
import game.state.State;
import map.Tile;
import utils.Constants;

import java.awt.*;

public class Renderer {
    public void render(State state, Graphics graphics) {
        renderTiles(state, graphics);
        Camera camera = state.getCamera();
        state.getGameObjects().stream()
                .filter(camera::isInView)
                .forEach(gameObject ->
                        graphics.drawImage(
                                gameObject.getSprite(),
                                gameObject.getPosition().intX(),
                                gameObject.getPosition().intY(),
                                null
                        )
        );
    }

    private void renderTiles(State state, Graphics graphics) {
        Tile[][] backgroundTiles = state.getGameMap().getTiles();
        Tile[][] riverTiles = state.getRiverMap().getTiles();
        Tile[][] interfaceTiles = state.getGameInterface().getTiles();
        Camera camera = state.getCamera();

        Position start = state.getGameMap().getViewableStartingGridPosition(camera);
        Position end = state.getGameMap().getViewableEndingGridPosition(camera);

        for (int x = start.intX(); x < end.intX(); x++) {
            for (int y = start.intY(); y < end.intY(); y++) {
                graphics.drawImage(
                        backgroundTiles[x][y].getSprite(),
                        x * Constants.TILE_SIZE,
                        y * Constants.TILE_SIZE - camera.getPosition().intY(),
                        null
                );
            }
        }
//        for (int x = 0; x < riverTiles.length; x++) {
//            for (int y = 0; y < riverTiles[0].length; y++) {
//                graphics.drawImage(
//                        riverTiles[x][y].getSprite(),
//                        Constants.SCREEN_SIZE.width / 2 - Constants.TILE_SIZE,
//                        y * Constants.TILE_SIZE,// - camera.getPosition().intY(),
//                        null
//                );
//            }
//        }
//        for (int x = 0; x < interfaceTiles.length; x++) {
//            for (int y = 0; y < interfaceTiles[0].length; y++) {
//                graphics.drawImage(
//                        interfaceTiles[x][y].getSprite(),
//                        x * Constants.TILE_SIZE,
//                        state.getGameInterface().getPosition().intY() - 250,
//                        null
//                );
//            }
//        }
    }
}
