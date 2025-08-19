package ru.otus.java.basic;

import java.util.Scanner;

public class HomeWorkPanichenko {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число от 1 до 5 для выбора метода");
        while (true) {

            int methodNum = scanner.nextInt();

            if (methodNum == 1) {
                System.out.println("Метод greetings()");
                greetings();
            } else if (methodNum == 2) {

                int a = -(int) (Math.random() * 100 + 1);
                int b = (int) (Math.random() * 10 + 1);
                int c = (int) (Math.random() * 100 + 1);
                System.out.println("Метод checkSign()");
                System.out.println("Выводится знак результата суммирования чисел а = " + a + "; b = " + b + "; c = " + c + ";");

                checkSign(a, b, c);
            } else if (methodNum == 3) {
                System.out.println("Метод selectColor()");
                selectColor();
            } else if (methodNum == 4) {
                System.out.println("Метод compareNumbers()");
                compareNumbers();
            } else if (methodNum == 5) {

                int percent = 50;
                int range = (int) (Math.random() * 100 + 1);
                boolean increment = range > percent;
                int initValue = (int) (Math.random() * 100 + 1);
                int delta = (int) (Math.random() * 10 + 1);

                System.out.println("Метод addOrSubtractAndPrint()");
                if (increment) {
                    System.out.println("Инкремент положительный");
                } else {
                    System.out.println("Инкремент отрицательный");
                }
                System.out.println("Изначальное число = " + initValue + "; Дельта = " + delta);
                addOrSubtractAndPrint(initValue, delta, increment);

            } else {
                System.out.println("Вы ввели недопустимое число");
                System.out.println("Введите число из диапазона 1-5");


            }
        }

    }


    public static void greetings() {
        System.out.println("Hello");
        System.out.println("World");
        System.out.println("from");
        System.out.println("Java");
    }

    public static void checkSign(int a, int b, int c) {
        int result = a + b + c;
        if (result > 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void selectColor() {
        int data = 99999;
        if (data <= 10) {
            System.out.println("Красный");
        } else if (data <= 20) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers() {
        int a = 10;
        int b = -10;
        if (a >= b) {
            System.out.println("a>=b");
        } else {
            System.out.println("a<b");
        }

    }

    public static void addOrSubtractAndPrint(int initValue, int delta, boolean increment) {
        if (increment) {
            int result = initValue + delta;
            System.out.println("Результат сложения = " + result);
        } else {
            int result = initValue - delta;
            System.out.println("Результат вычитания = " + result);
        }
    }
}



