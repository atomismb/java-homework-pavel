package ru.otus.java.basic;

public class HomeWorkPanichenko {
    public static void main(String[] args) {
    }

    public static int sumPositiveElements(int[][] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > 0) {
                    sum += array[i][j];
                }
            }
        }
        return sum;
    }

    public static void drawSquare(int[][] array2) {
        for (int i = 0; i < array2.length; i++) {
            System.out.println();
            for (int j = 0; j < array2[i].length; j++) {
                System.out.print("*");
            }
        }
    }

    public static void toNullDiagonal(int[][] array3) {
        for (int i = 0; i < array3.length; i++) {
            for (int j = 0; j < array3[i].length; j++) {
                if (i == j) {
                    array3[i][j] = 0;
                }
            }
        }

    }

    public static int findMax(int[][] array4) {
        int max = 0;
        for (int i = 0; i < array4.length; i++) {
            for (int j = 0; j < array4[i].length; j++) {
                if (array4[i][j] > max) {
                    max = array4[i][j];
                }
            }
        }
        return max;
    }

    public static int sumSecondRow(int[][] array5) {
        int sum = 0;
        if (array5.length < 2) {
            return -1;
        }
        for (int i = 0; i < array5[1].length; i++) {
            sum += array5[1][i];
        }
        return sum;
    }
}