package ru.otus.java.basic;

import java.util.ArrayList;

public class HomeWorkPanichenko {
    public static void main(String[] args) {
    }

    public static ArrayList<String> minMaxList(int max, int min) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            list.add(String.valueOf(min));
            min++;
        }
        return list;
    }

    public static int sumOverFive(ArrayList<String> list) {
        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            int number = Integer.parseInt(list.get(i));
            if (number > 5) {
                result += number;
            }
        }
        return result;
    }

    public static void changeNumber(int number, ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, String.valueOf(number));
        }
        System.out.println(list);
    }

    public static void increaseNumber(int number, ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            int b = number + Integer.parseInt(list.get(i));
            list.set(i, String.valueOf(b));
        }
        System.out.println(list);
    }
}
