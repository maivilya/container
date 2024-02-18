package org.example.Geek.Threads.PhilosophersAndForks;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Philosopher extends Thread {

    private final int id;
    private final Table table;
    private final Fork leftFork;
    private final Fork rightFork;
    private final CountDownLatch cdl;
    private static final Random random = new Random();
    private int countEat;

    public Philosopher(int id, Table table, Fork leftFork, Fork rightFork, CountDownLatch cdl) {
        this.id = id;
        this.table = table;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.cdl = cdl;
        this.countEat = 0;
    }

    @Override
    public void run() {
        while (countEat < 3) {
            thinking();
            eating();
        }
        System.out.printf("Philosopher#%d end eat today\n", id);
        cdl.countDown();
    }

    private void thinking() {
        try {
            sleep(random.nextInt((5000 - 3000) + 1) + 3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void eating() {
        if (table.getTwoForks(leftFork, rightFork)) {
            System.out.printf("Philosopher#%d is eating with forks left(%d) and right(%d)\n",
                    id, leftFork.getId(), rightFork.getId()
            );
            try {
                sleep(random.nextInt((3000 - 1000) + 1) + 1000);
                table.putForks(leftFork, rightFork);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("Philosopher#%d eat %d times\n", id, ++countEat);
            System.out.printf("Philosopher#%d is thinking\n", id);
        }
    }
}
