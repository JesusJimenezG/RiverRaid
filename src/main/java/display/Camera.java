package display;

import entity.GameObject;
import entity.Position;
import entity.Size;
import game.state.State;

import java.awt.*;
import java.util.Optional;

public class Camera {
    private Position position;
    private Size windowSize;

    private Rectangle viewBounds;

    private Optional<GameObject> objectWithFocus;

    public Camera(Size windowSize) {
        position = new Position(0, 0);
        this.windowSize = windowSize;
        calculateViewBounds();
    }

    private void calculateViewBounds() {
        viewBounds = new Rectangle(position.intX(), position.intY(), windowSize.getWidth(), windowSize.getHeight());
    }

    public void focusOn(GameObject object){
        this.objectWithFocus = Optional.of(object);
    }

    public void update(State state){
        if (objectWithFocus.isPresent()){
            Position objectPosition = objectWithFocus.get().getPosition();
            position.setX(objectPosition.getX() - (double) windowSize.getWidth() / 2);
            position.setY(objectPosition.getY() - (double) windowSize.getHeight() / 2);
//            calculateViewBounds();
        }
    }

    public Position getPosition() {
        return position;
    }

    public boolean isInView(GameObject gameObject) {
        return viewBounds.intersects(
                gameObject.getPosition().intX(),
                gameObject.getPosition().intY(),
                gameObject.getSize().getWidth(),
                gameObject.getSize().getHeight()
        );
    }

    public Size getSize() {
        return windowSize;
    }
}
