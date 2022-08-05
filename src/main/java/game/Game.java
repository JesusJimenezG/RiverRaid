package game;

import controller.Input;
import display.Display;
import entity.Size;
import game.state.GameState;
import game.state.State;
import utils.Constants;

public class Game {

    private Display display;
    private Input input;
    private State state;

    public Game() {
        input = new Input();
        display = new Display(input);
        state = new GameState(new Size(Constants.SCREEN_SIZE.width, Constants.SCREEN_SIZE.height), input);
    }

    public void update(){
        state.update();
    }

    public void render(){
        display.render(state);
    }
}
