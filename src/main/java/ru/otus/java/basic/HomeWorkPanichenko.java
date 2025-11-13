package ru.otus.java.basic;

import java.util.ArrayList;

public class HomeWorkPanichenko {
    public static void main(String[] args) {
    }

    public static ArrayList<Integer> minMaxList(int max, int min) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            list.add(min);
            min++;
        }
        return list;
    }

    public static int sumOverFive(ArrayList<Integer> list) {
        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            int number = list.get(i);
            if (number > 5) {
                result += number;
            }
        }
        return result;
    }

    public static void changeNumber(int number, ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, number);
        }
        System.out.println(list);
    }

    public static void increaseNumber(int number, ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            int b = number + list.get(i);
            list.set(i, b);
        }
        System.out.println(list);
    }
}
