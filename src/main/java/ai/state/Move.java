package ai.state;

import ai.AITransition;
import controller.NPCController;
import entity.NPC;
import entity.Position;
import game.state.State;

import java.util.ArrayList;
import java.util.List;

public class Move extends AIState {

    private List<Position> targets;

    public Move() {
        super();
        targets = new ArrayList<>();
    }

    @Override
    protected AITransition initializeTransition() {
        return new AITransition("stand", ((state, currentCharacter) -> arrived(currentCharacter)));
    }

    @Override
    public void update(State state, NPC currentCharacter) {
        if (targets.isEmpty()) {
            targets.add(state.getRandomPosition());
        }

        NPCController controller = (NPCController) currentCharacter.getController();
        controller.moveToTarget(targets.get(0), currentCharacter.getPosition());

        if (arrived(currentCharacter)) {
            controller.stop();
//            targets.remove(0);
        }
    }

    private boolean arrived(NPC currentCharacter) {
        return currentCharacter.getPosition().isInRangeOf(targets.get(0));
    }
}
