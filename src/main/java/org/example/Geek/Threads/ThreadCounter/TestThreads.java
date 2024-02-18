package org.example.Geek.Threads.ThreadCounter;

public class TestThreads {

    public static void main(String[] args) {
        Counter counter = new Counter();

        ThreadIncrementer t1 = new ThreadIncrementer(counter);
        ThreadDecrementor t2 = new ThreadDecrementor(counter);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("counter.getCount() = " + counter.getCount());
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
