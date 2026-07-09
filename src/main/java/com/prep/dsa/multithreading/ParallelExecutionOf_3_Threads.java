package com.prep.dsa.multithreading;
//        How can we run 3 threads parallel
//        so that it will print output like this
//        Thread - 1 --> Print - 1
//        Thread - 2 --> Print - 2
//        Thread - 3 --> Print - 3
//        Thread - 1 --> Print - 4
//        Thread - 2 --> Print - 5

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ParallelExecutionOf_3_Threads {


    private int number = 1;
    private final int MAX = 15;

    public synchronized void print(int threadNo) {

        while (number <= MAX) {

            while ((number - 1) % 3 != threadNo) {
                if (number > MAX)
                    return;

                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            if (number <= MAX) {
                System.out.println(
                        Thread.currentThread().getName()
                                + " --> Print-" + number);
                number++;
            }

            notifyAll();
        }
    }

    public static void main(String[] args) {

        ParallelExecutionOf_3_Threads obj = new ParallelExecutionOf_3_Threads();

        Thread t1 = new Thread(() -> obj.print(0), "Thread-1");
        Thread t2 = new Thread(() -> obj.print(1), "Thread-2");
        Thread t3 = new Thread(() -> obj.print(2), "Thread-3");

        t1.start();
        t2.start();
        t3.start();
    }




}
