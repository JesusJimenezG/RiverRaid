package game;

public class Timer {
    private int updatesSinceStart;

    public Timer() {
        updatesSinceStart = 0;
    }

    public int getUpdatesFromSeconds(int seconds){
        return seconds * GameLoop.UPDATES_PER_SECOND;
    }
}
