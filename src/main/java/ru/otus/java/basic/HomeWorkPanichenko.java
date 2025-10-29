package ru.otus.java.basic;

import java.io.IOException;
import java.util.*;

public class HomeWorkPanichenko {
    public static Scanner scanner = new Scanner(System.in);
    public static FileManager fileManager = new FileManager();

    public static void main(String[] args) {
        try {
            showAvailableFiles();
            String fileName = selectFile();
            showFileText(fileName);
            startWritingToFile(fileName);
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    public static void showAvailableFiles() {
        System.out.println("Список текстовых файлов из корневого каталога:");
        String[] textFiles = fileManager.getTextFiles();
        if (textFiles.length == 0) {
            System.out.println("Текстовые файлы не найдены");
        } else {
            for (String fileName : textFiles) {
                System.out.println(fileName);
            }
        }
        System.out.println();
    }

    public static String selectFile() {
        System.out.print("Введите имя файла для работы (с расширением .txt или без): ");
        String fileName = scanner.nextLine().trim();
        if (!fileName.toLowerCase().endsWith(".txt")) {
            fileName += ".txt";
        }
        System.out.println("Выбран файл: " + fileName);
        return fileName;
    }

    public static void showFileText(String fileName) {
        System.out.println("\nСодержимое файла '" + fileName + "':\n");
        try {
            if (fileManager.fileExists(fileName)) {
                String content = fileManager.readFile(fileName);
                if (content.isEmpty()) {
                    System.out.println("Файл пустой");
                } else {
                    System.out.println(content);
                }
            } else {
                System.out.println("Файл не существует. Будет создан новый файл.");
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

    private static void startWritingToFile(String fileName) {
        System.out.println("Введите текст для записи в файл или для выхода из программы: 'exit')");
        while (true) {
            String input = scanner.nextLine();
            if ("exit".equalsIgnoreCase(input)) {
                System.out.println("Работа с текстовым файлом завершена.");
                break;
            }
            try {
                String textToWrite = input + System.lineSeparator();
                fileManager.writeToFile(fileName, textToWrite, true);
                System.out.println("Текст успешно записан в файл.");
            } catch (IOException e) {
                System.out.println("Ошибка при записи в файл: " + e.getMessage());
            }
        }
    }
}
