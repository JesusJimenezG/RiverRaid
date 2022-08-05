package game.state;

import controller.EntityController;
import controller.Input;
import core.Interface;
import display.Camera;
import entity.GameObject;
import entity.Player;
import entity.Position;
import entity.Size;
import game.Timer;
import gfx.SpriteLibrary;
import map.GameMap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class State {
    protected Input input;
    protected List<GameObject> gameObjects;
    protected SpriteLibrary spriteLibrary;
    protected GameMap gameMap;
    protected GameMap riverMap;

    protected Interface gameInterface;
    protected Camera camera;
    protected Timer timer;

    public State(Size windowSize, Input input) {
        this.input = input;
        gameObjects = new ArrayList<>();
        spriteLibrary = new SpriteLibrary();
        camera = new Camera(windowSize);
        timer = new Timer();
    }

    public void update(){
//        sortObjectsByPosition();
        gameObjects.forEach(gameObject -> gameObject.update(this));
        camera.update(this );
    }

    private void sortObjectsByPosition() {
        gameObjects.sort(Comparator.comparing(
                gameObjects -> gameObjects.getPosition().getY()
        ));
    }

    public List<GameObject> getGameObjects() {
        return gameObjects;
    }

    public GameMap getGameMap() {
        return gameMap;
    }
    public GameMap getRiverMap() {
        return riverMap;
    }
    public Interface getGameInterface() {
        return gameInterface;
    }

    public Camera getCamera() {
        return camera;
    }

    public Timer getTimer() {
        return timer;
    }

    public Position getRandomPosition() {
        return gameMap.getRandomPosition();
    }
}
