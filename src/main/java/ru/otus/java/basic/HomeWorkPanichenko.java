package ru.otus.java.basic;

import java.util.ArrayList;

public class HomeWorkPanichenko {
    public static void main(String[] args) {
        //System.out.println(minMaxList(10,1));
        sumOverFive(minMaxList(10,1));

    }
    public static ArrayList minMaxList(int max, int min){
        ArrayList list = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            list.add(String.valueOf(min));
            min++;
        }
        return list;
    }
    public static int sumOverFive (ArrayList list){
        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            String number = (String) list.get(i);
            number
             if (number > 5){
                result += number;
            }

        }
        return result;
    }
}
