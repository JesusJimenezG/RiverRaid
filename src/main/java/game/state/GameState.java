package game.state;

import controller.EntityController;
import controller.Input;
import controller.NPCController;
import core.Interface;
import display.Scroller;
import entity.NPC;
import entity.Player;
import entity.Position;
import entity.Size;
import map.GameMap;
import utils.Constants;

import java.util.List;


public class GameState extends State{
    public GameState(Size windowSize, Input input) {
        super(windowSize, input);
        initializeMap();
        initializeCharacters();
    }

    private void initializeMap() {
        gameMap = new GameMap(
                new Size(Constants.TILE_SIZE, Constants.TILE_SIZE),
                spriteLibrary,
                Constants.BACKGROUND_TILE
        );
        riverMap = new GameMap(
                new Size(Constants.SCREEN_SIZE.width, Constants.SCREEN_SIZE.height),
                spriteLibrary,
                Constants.RIVER_TILE
        );
        gameInterface = new Interface(
                new Position(0, Constants.SCREEN_SIZE.height),
                new Size(Constants.TILE_SIZE, Constants.TILE_SIZE),
                spriteLibrary
        );
        Scroller scroller = new Scroller();
        gameObjects.add(scroller);
//        gameObjects.add(gameInterface);
        camera.focusOn(scroller);
    }

    private void initializeCharacters() {
        Player player = new Player(
                new EntityController(input),
                spriteLibrary,
                new Position(
                        Constants.SCREEN_SIZE.width / 2 - Constants.SPRITE_WIDTH,
                        Constants.SCREEN_SIZE.height - Constants.INTERFACE_SIZE
                ),
                new Size(Constants.SPRITE_WIDTH, Constants.SPRITE_HEIGHT)
        );
        gameObjects.add(player);

        initializeNPCs(3);
    }

    private void initializeNPCs(int num) {
        for (int i = 0; i < num; i++) {
            NPC npc = new NPC(
                    new NPCController(),
                    spriteLibrary,
                    new Position(gameMap.getRandomPosition().getX(), gameMap.getRandomPosition().getY()),
                    new Size(Constants.SPRITE_WIDTH, Constants.SPRITE_HEIGHT)
            );
            gameObjects.add(npc);
        }

    }
}
