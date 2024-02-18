package org.example.Geek.Threads.PhilosophersAndForks;

public class Fork {

    private final int id;
    private boolean isUsing;

    public Fork(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public boolean getUsing() {
        return isUsing;
    }

    public void setUsing(boolean isUsing) {
        this.isUsing = isUsing;
    }
}
