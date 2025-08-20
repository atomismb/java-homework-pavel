package ru.otus.java.basic;

import java.util.Arrays;
import java.util.Scanner;

public class HomeWorkPanichenko {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //repeatRow(5,"Hello OTUS!");
        //sumArray(new int[] {4,6,1,3,4,8,7,10});
        fillArray(200, new int[10]);
    }

    public static void repeatRow(int rowNumber, String row) {
        for (int i = 0; i < rowNumber; i++) {
            System.out.println(row);
        }
    }

    public static void sumArray(int[] array1) {
        int result = 0;
        for (int i = 0; i < array1.length; i++) {

            if (array1[i] > 5) {
                result += array1[i];
            }
        }
        System.out.println(result);
    }

    public static void fillArray(int number, int[] array2) {
        for (int i = 0; i < array2.length; i++) {
            array2[i] = number;
        }
        System.out.println(Arrays.toString(array2));
    }


}



