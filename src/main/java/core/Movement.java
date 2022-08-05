package core;

import controller.Controller;

public class Movement {
    private Vector2D vector;
    private double speed;
    private boolean isMoving;

    public Movement(double speed) {
        this.speed = speed;
        vector = new Vector2D(0, 0);
    }

    public void update(Controller controller){
        int deltaX = 0, deltaY = 0;

        if (controller.isRequestingLeft()){
            deltaX--;
            isMoving = true;
        }
        if (controller.isRequestingRight()){
            deltaX++;
            isMoving = true;
        }

        vector = new Vector2D(deltaX, deltaY);
        vector.normalize();
        vector.multiply(speed);
    }

    public void scroll(){
        int deltaX = 0, deltaY = 0;

        deltaY++;

        vector = new Vector2D(deltaX, deltaY);
//        vector.normalize();
        vector.multiply(speed);
    }

    public Vector2D getVector() {
        return vector;
    }

    public boolean isMoving() {
//        System.out.println(vector.length());
        return isMoving;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
