package ru.otus.java.basic;

public class SortUtils {

    public static void bubbleSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void quickSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int index = chunk(array, low, high);
            quickSort(array, low, index - 1);
            quickSort(array, index + 1, high);
        }
    }

    private static int chunk(int[] array, int low, int high) {
        int a = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] <= a) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }
}