package core;

public enum Direction {
    Up(1),
    Right(2),
    Down(3),
    Left(0);
    private int animationRow;

    Direction(int animationRow){
        this.animationRow = animationRow;
    }

    public static Direction fromMovement(Movement movement){
        double x = movement.getVector().getX();
        double y = movement.getVector().getY();

        if (x < 0) return Left;
        if (x > 0) return Right;

        return Up;
    }

    public int getAnimationRow() {
        return animationRow;
    }
}
