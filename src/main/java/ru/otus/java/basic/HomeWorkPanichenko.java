package ru.otus.java.basic;

public class HomeWorkPanichenko {
    public static void main(String[] args) {
    }

    public static int[] getElementsAfterLastOne(int[] array) {
        if (array == null || array.length == 0) {
            throw new RuntimeException("Массив пустой или null");
        }

        int lastOneIndex = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                lastOneIndex = i;
            }
        }

        if (lastOneIndex == -1) {
            throw new RuntimeException("Массив не содержит единиц");
        }

        if (lastOneIndex == array.length - 1) {
            return new int[0];
        }

        int resultLength = array.length - lastOneIndex - 1;
        int[] result = new int[resultLength];

        for (int i = 0; i < resultLength; i++) {
            result[i] = array[lastOneIndex + 1 + i];
        }
        return result;
    }

    public static boolean containsOnlyOneAndTwo(int[] array) {
        if (array == null || array.length < 2) {
            return false;
        }

        boolean hasOne = false;
        boolean hasTwo = false;

        for (int value : array) {
            if (value != 1 && value != 2) {
                return false;
            }

            if (value == 1) {
                hasOne = true;
            } else if (value == 2) {
                hasTwo = true;
            }
        }
        return hasOne && hasTwo;
    }
}
