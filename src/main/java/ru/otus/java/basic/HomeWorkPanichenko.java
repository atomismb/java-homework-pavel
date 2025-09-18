package ru.otus.java.basic;

import java.util.Arrays;

public class HomeWorkPanichenko {
    public static void main(String[] args) {
        String[][] array1 = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}

        };
        String[][] array2 = {
                {"1", "2", "3", "4"},
                {"5", "b", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}

        };
        String[][] array3 = {
                {"1", "2", "3"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}

        };
        String[][] array4 = {
                {"1", "2", "3", "4"},
                {"5", "6bg", "7", "8"},
                {"9", "10", "11", "12"}

        };
        try {
            sumArray(array1);
            sumArray(array2);
        } catch (AppArraySizeException | AppArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

    }

    public static void sumArray(String[][] array) {
        if (array.length != 4) {
            throw new AppArraySizeException("Получено исключение AppArraySizeException!\nВ массиве не 4 строки, а " + array.length + "!");
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new AppArraySizeException("Получено исключение AppArraySizeException!\nВ массиве не 4 столбца, а " + array[i].length + "!");
            }

        }
        System.out.println("В массиве 4 строки и 4 столбца!");
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new AppArrayDataException("Получено исключение AppArrayDataException!\nВ ячейке " + "[" + i + "]" + "[" + j + "] массива лежит: " + "\"" + array[i][j] + "\"");
                }

            }

        }
        System.out.println("Полученная сумма всех чисел в массиве = " + sum);
        System.out.println();

    }
}
