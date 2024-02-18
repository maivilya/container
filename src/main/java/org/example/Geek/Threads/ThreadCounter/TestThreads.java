package org.example.Geek.Threads.ThreadCounter;

public class TestThreads {

    public static void main(String[] args) {

    }

}

class ThreadDecrementor extends Thread {
    private final Counter counter;

    ThreadDecrementor(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50_000; i++) {
            counter.decrement();
        }
    }
}

class ThreadIncrementer extends Thread {
    private final Counter counter;

    ThreadIncrementer(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50_000; i++) {
            counter.increment();
        }
    }
}

class Counter {
    private int count;
    private final Object mutex = new Object();

    public void increment() {
        synchronized(mutex) {
            count++;
        }
    }

    public void decrement() {
        synchronized(mutex) {
            count--;
        }
    }

    public int getCount() {
        return count;
    }
}
