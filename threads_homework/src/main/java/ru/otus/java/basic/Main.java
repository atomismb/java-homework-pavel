package ru.otus.java.basic;

public class Main {
    public static void main(String[] args) {
        long startTime1 = System.currentTimeMillis();
        fillArraySimple();
        long endTime1 = System.currentTimeMillis();
        long duration1 = endTime1 - startTime1;
        System.out.println("Время выполнения без потоков: " + duration1 + " мс");

        long startTime2 = System.currentTimeMillis();
        fillArrayUsingThreads();
        long endTime2 = System.currentTimeMillis();
        long duration2 = endTime2 - startTime2;
        System.out.println("Время выполнения с потоками: " + duration2 + " мс");
    }

    public static void fillArraySimple() {
        double[] arr = new double[100_000_000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
        }
    }

    public static void fillArrayUsingThreads() {
        double[] arr = new double[100_000_000];
        Thread first = new Thread(() -> {
            for (int i = 0; i < arr.length / 4; i++) {
                arr[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
            }
        });
        Thread second = new Thread(() -> {
            for (int i = arr.length / 4; i < arr.length / 2; i++) {
                arr[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
            }
        });
        Thread third = new Thread(() -> {
            for (int i = arr.length / 2; i < 3 * arr.length / 4; i++) {
                arr[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
            }
        });
        Thread fourth = new Thread(() -> {
            for (int i = 3 * arr.length / 4; i < arr.length; i++) {
                arr[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
            }
        });
        first.start();
        second.start();
        third.start();
        fourth.start();
        try{
            first.join();
            second.join();
            third.join();
            fourth.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}