package game;

public class GameLoop implements Runnable{

    public static final int UPDATES_PER_SECOND = 60;
    private Game game;
    private long nextStatTime;
    private int fps,ups;

    private final double updateRate = 1.0d/UPDATES_PER_SECOND;

    public GameLoop(Game game){ this.game = game; }

    @Override
    public void run() {
        double accumulator = 0;
        long currentTime, lastUpdate = System.currentTimeMillis();
        nextStatTime = System.currentTimeMillis() + 1000;

        while (true) {
            currentTime = System.currentTimeMillis();
            double lastRenderTimeInSeconds = (currentTime - lastUpdate) / 1000d;
            accumulator += lastRenderTimeInSeconds;
            lastUpdate = currentTime;

            if (accumulator >= updateRate){
                while (accumulator > updateRate) {
                    update();
                    accumulator -= updateRate;
                }
                render();
            }
            printStats();
        }
    }

    private void printStats() {
        if (System.currentTimeMillis() > nextStatTime){
            System.out.printf("FPS: %d,UPS: %d%n", fps, ups);
            fps = 0;
            ups = 0;
            nextStatTime = System.currentTimeMillis() + 1000;
        }
    }

    public void update() {
        game.update();
        ups++;
    }

    public void render() {
        game.render();
        fps++;
    }
}
