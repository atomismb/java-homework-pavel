package ru.otus.java.basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HomeWorkPanichenko {

    public static void main(String[] args) {
        final Object mon = new Object();
        int[] turn = {0};
        int cycle = 5;

        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.execute(() -> {
            synchronized (mon) {
                for (int i = 0; i < cycle; i++) {
                    try {
                        while (turn[0] != 0) {
                            mon.wait();
                        }
                        System.out.print("A");
                        turn[0] = 1;
                        mon.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        executor.execute(() -> {
            synchronized (mon) {
                for (int i = 0; i < cycle; i++) {
                    try {
                        while (turn[0] != 1) {
                            mon.wait();
                        }
                        System.out.print("B");
                        turn[0] = 2;
                        mon.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        executor.execute(() -> {
            synchronized (mon) {
                for (int i = 0; i < cycle; i++) {
                    try {
                        while (turn[0] != 2) {
                            mon.wait();
                        }
                        System.out.print("C");
                        turn[0] = 0;
                        mon.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        executor.shutdown();
    }
}