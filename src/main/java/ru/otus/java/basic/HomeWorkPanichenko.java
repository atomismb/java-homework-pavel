package ru.otus.java.basic;

import java.util.Arrays;
import java.util.Scanner;

public class HomeWorkPanichenko {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //repeatRow(5,"Hello OTUS!");
        //sumArray(new int[] {4,6,1,3,4,8,7,10});
       // fillArray(200, new int[10]);
        //arrayIncrease(2, new int[] {2,4,5,1,3,6,7,15});
        //whichHalfIsBigger(new int[] {1,1,1,2,2,2,2});
        //sumOfSeveralArrays(new int[] {1,1,1,1},new int[] {2,2,2},new int[] {3,3,3,3},new int[] {4,4});
        //thePoint(new int[] {1,2,3,5,1});
        increseOrDecrease(new int[] {6,5,4});
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
    public static void arrayIncrease(int number, int[] array3) {
        for (int i = 0; i < array3.length; i++) {
            array3[i] += number;
        }
        System.out.println(Arrays.toString(array3));
    }
    public static void whichHalfIsBigger(int[] array4) {
        int sumLeft = 0;
        int sumRight = 0;

        for (int i = 0; i < array4.length/2; i++) {
            sumLeft += array4[i];
        }
        for (int i = array4.length/2; i < array4.length ; i++) {
            sumRight += array4[i];

        }
        if (sumRight>sumLeft){
            System.out.println("Сумма правой половины массива больше");

        } else {
            System.out.println("Сумма левой половины массива больше");
        }
    }

        public static void sumOfSeveralArrays(int[] array5,int[] array6,int[] array7,int[] array8) {
            int maxArrayLength56 = Math.max(array5.length,array6.length);
            int maxArrayLength78 = Math.max(array7.length,array8.length);
            int maxArrayLength = Math.max(maxArrayLength78,maxArrayLength56);
            int[] arrayResult = new int[maxArrayLength];
            for (int i = 0; i < array5.length; i++) {
                arrayResult[i] +=array5[i];
            }for (int i = 0; i < array6.length; i++) {
                arrayResult[i] +=array6[i];
            }for (int i = 0; i < array7.length; i++) {
                arrayResult[i] +=array7[i];
            }for (int i = 0; i < array8.length; i++) {
                arrayResult[i] +=array8[i];
            }
            System.out.println(Arrays.toString(arrayResult));

            }
            public static void thePoint (int[] array9){
                for (int i = 1; i < array9.length; i++) {
                    int leftSide = 0;
                    int rightSide = 0;
                    for (int j = 0; j < i; j++) {
                        leftSide += array9[j];
                    }
                    for (int j = i; j < array9.length; j++) {
                        rightSide += array9[j];
                    }
                    if (rightSide == leftSide){
                        System.out.println("Точка находится между элементами массива " + (i-1) + " и " + i);
                    }

                    
                }
            }
public static void increseOrDecrease(int[] array10){
        Scanner scanner = new Scanner(System.in);
    System.out.println("Введите число 1, если \"по возрастанию\" или число 2, если \"по убыванию\"");
    int decreaseIncrease = scanner.nextInt();
     boolean check = true;
    if (decreaseIncrease == 1) {

        for (int i = 1; i < array10.length; i++) {
            if (array10[i] > array10[i - 1]) {
            } else {
                System.out.println("Не все значения идут по возрастанию");
                check = false;
                break;
            }
        }
        if (check){
            System.out.println("Все значения идут по возрастанию");
        }
    }
    if (decreaseIncrease == 2){
        boolean check2 = true;
        for (int i = 1; i < array10.length; i++) {
            if (array10[i-1] > array10[i]){}
            else {
                System.out.println("Не все значения идут по убыванию");
                check2 = false;
                break;
            }
        }
        if (check2){
        System.out.println("Все значения идут по убыванию");}

    }

}


}



