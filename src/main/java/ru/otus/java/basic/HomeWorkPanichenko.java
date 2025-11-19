package ru.otus.java.basic;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class HomeWorkPanichenko {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя файла: ");
        String fileName = scanner.nextLine();

        System.out.print("Введите искомую последовательность символов: ");
        String searchData = scanner.nextLine();

        try {
            int count = countSequenceOccurr(fileName, searchData);
            System.out.println("Количество совпадений для '" + searchData + "': " + count);
        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлом: " + e.getMessage());
        }
        scanner.close();
    }

    public static int countSequenceOccurr(String fileName, String searchData) throws IOException {
        if (searchData.isEmpty()) {
            return 0;
        }
        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
            byte[] buffer = fileInputStream.readAllBytes();
            String data = new String(buffer, StandardCharsets.UTF_8);
            int count = 0;
            int index = 0;
            while ((index = data.indexOf(searchData, index)) != -1) {
                count++;
                index += searchData.length();
            }
            return count;
        }
    }
}