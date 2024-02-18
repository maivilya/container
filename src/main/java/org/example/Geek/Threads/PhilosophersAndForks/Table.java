package org.example.Geek.Threads.PhilosophersAndForks;

import java.util.concurrent.CountDownLatch;

public class Table extends Thread {

    private final int PHILOSOPHER_COUNT = 5;
    private final Philosopher[] philosophers;
    private final Fork[] forks;
    private final CountDownLatch cdl;

    public Table() {
        philosophers = new Philosopher[PHILOSOPHER_COUNT];
        forks = new Fork[PHILOSOPHER_COUNT];
        cdl = new CountDownLatch(PHILOSOPHER_COUNT);
        createForks();
        createPhilosophers();
    }

    @Override
    public void run() {
        System.out.println("Day is started");
        try {
            allPhilosophersIsThinking();
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Day is finished");
    }

    public synchronized boolean getTwoForks(Fork leftFork, Fork rightFork) {
        if (!forks[leftFork.getId() - 1].getUsing() && !forks[rightFork.getId() - 1].getUsing()) {
            leftFork.setUsing(true);
            rightFork.setUsing(true);
            return true;
        }
        return false;
    }

    public void putForks(Fork leftFork, Fork rightFork) {
        leftFork.setUsing(false);
        rightFork.setUsing(false);
    }

    private void createPhilosophers() {
        for (int i = 0; i < philosophers.length; i++) {
            philosophers[i] = new Philosopher((i + 1), this, forks[i], forks[(i+1) % PHILOSOPHER_COUNT], cdl);
        }
    }

    private void createForks() {
        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Fork((i + 1));
        }
    }

    private void allPhilosophersIsThinking() {
        for (Philosopher philosopher : philosophers) {
            philosopher.start();
        }
    }
}
