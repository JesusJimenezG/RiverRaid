package ai;

import ai.state.AIState;
import ai.state.Move;
import ai.state.Stand;
import entity.NPC;
import game.state.State;

public class AIManager {
    private AIState currentAIState;

    public AIManager() {
        transitionTo("stand");
    }

    public void update(State state, NPC currentCharacter){
        currentAIState.update(state, currentCharacter);
        if (currentAIState.shouldTransition(state, currentCharacter)){
            transitionTo(currentAIState.getNextState());
        }
    }

    private void transitionTo(String nextState) {
        System.out.println("Transitioning to: " + nextState);
        switch (nextState){
            case "move":
                currentAIState = new Move();
                return;
            case "stand":
                currentAIState = new Stand();
                return;
            default:
                currentAIState = new Stand();
        }
    }
}
