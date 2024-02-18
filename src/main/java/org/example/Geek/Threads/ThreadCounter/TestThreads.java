package org.example.Geek.Threads.ThreadCounter;

public class TestThreads {

    public static void main(String[] args) {

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
