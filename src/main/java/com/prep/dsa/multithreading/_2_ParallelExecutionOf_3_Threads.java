package com.prep.dsa.multithreading;
//        How can we run 3 threads parallel
//        so that it will print output like this
//        Thread - 1 --> Print - 1
//        Thread - 2 --> Print - 2
//        Thread - 3 --> Print - 3
//        Thread - 1 --> Print - 4
//        Thread - 2 --> Print - 5

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class _2_ParallelExecutionOf_3_Threads {

    private int number = 1;
    private final int MAX = 15;

    private final Lock lock = new ReentrantLock();

    private final Condition c1 = lock.newCondition();
    private final Condition c2 = lock.newCondition();
    private final Condition c3 = lock.newCondition();

    public void print(int threadNo) {

        lock.lock();

        try {

            while (number <= MAX) {

                while ((number - 1) % 3 != threadNo) {

                    switch (threadNo) {
                        case 0 -> c1.await();
                        case 1 -> c2.await();
                        case 2 -> c3.await();
                    }

                    if (number > MAX) {
                        c1.signal();c2.signal();c3.signal();
                        return;
                    }
                }

                System.out.println(Thread.currentThread().getName()
                        + " -> " + number);

                number++;

                switch ((number - 1) % 3) {
                    case 0 -> c1.signal();
                    case 1 -> c2.signal();
                    case 2 -> c3.signal();
                }
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {

        _2_ParallelExecutionOf_3_Threads obj = new _2_ParallelExecutionOf_3_Threads();

        new Thread(() -> obj.print(0), "Thread-1").start();
        new Thread(() -> obj.print(1), "Thread-2").start();
        new Thread(() -> obj.print(2), "Thread-3").start();
    }
}